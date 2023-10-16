package com.techelevator.controller;

import javax.validation.Valid;

import com.techelevator.dao.EmployeeDao;
import com.techelevator.dao.LandlordDao;
import com.techelevator.dao.TenantDao;
import com.techelevator.model.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.techelevator.dao.UserDao;
import com.techelevator.security.jwt.JWTFilter;
import com.techelevator.security.jwt.TokenProvider;

@RestController
@CrossOrigin
public class AuthenticationController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private UserDao userDao;
    private LandlordDao landlordDao;
    private TenantDao tenantDao;
    private EmployeeDao employeeDao;

    public AuthenticationController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, UserDao userDao, LandlordDao landlordDao, TenantDao tenantDao, EmployeeDao employeeDao) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDao = userDao;
        this.landlordDao = landlordDao;
        this.tenantDao = tenantDao;
        this.employeeDao = employeeDao;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginDto loginDto) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication, false);
        
        User user = userDao.findByUsername(loginDto.getUsername());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return new ResponseEntity<>(new LoginResponseDto(jwt, user), httpHeaders, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register(@Valid @RequestBody RegisterUserDto newUser) {
        try {
            User user = userDao.findByUsername(newUser.getUsername());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Already Exists.");

        } catch (UsernameNotFoundException e) {
            userDao.create(newUser.getUsername(),newUser.getPassword(), newUser.getRole(), newUser.getFirstname(), newUser.getLastname(), newUser.getEmail(), newUser.getPhone());
            User createdUser = userDao.findByUsername(newUser.getUsername());

            if (createdUser.getRole().equals("ROLE_LANDLORD")) {
                landlordDao.addLandlord(createdUser.getFirstname(), createdUser.getLastname(), createdUser.getEmail(), createdUser.getPhone(), createdUser.getId());
            }
            // if newUser.getRole tenant
             if (createdUser.getRole().equals("ROLE_TENANT")) {
                tenantDao.addTenant(createdUser.getFirstname(), createdUser.getLastname(), createdUser.getEmail(), createdUser.getPhone(), createdUser.getId());
            }

            // if newUser.getRole maintenance
            if (createdUser.getRole().equals("ROLE_EMPLOYEE")) {
                employeeDao.addEmployee(createdUser.getFirstname(), createdUser.getLastname(), createdUser.getEmail(), createdUser.getPhone(), createdUser.getId());
            }
        }
    }
}

