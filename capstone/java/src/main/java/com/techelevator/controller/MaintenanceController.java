package com.techelevator.controller;

import com.techelevator.dao.*;
import com.techelevator.model.*;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

    @RestController
    @RequestMapping("/maintenance")
    @CrossOrigin
    public class MaintenanceController {


        private MaintenanceDao maintenanceDao;
        private LandlordDao landlordDao;
        private TenantDao tenantDao;
        private UserDao userDao;
        private EmployeeDao employeeDao;

        public MaintenanceController(MaintenanceDao maintenanceDao, LandlordDao landlordDao, TenantDao tenantDao, UserDao userDao, EmployeeDao employeeDao) {
            this.maintenanceDao = maintenanceDao;
            this.userDao = userDao;
            this.tenantDao = tenantDao;
            this.landlordDao = landlordDao;
            this.employeeDao = employeeDao;
        }

        @RequestMapping(path = "/", method = RequestMethod.GET)
        public List<Maintenance> getMaintenance() {
            return maintenanceDao.getAllMaintenanceReqs();
        }



        @RequestMapping(path = "/allEmployees", method = RequestMethod.GET)
        public List<Employee> getEmployees() {
        return employeeDao.listOfEmployees();
        }

        @RequestMapping(path = "/updateEmployee/{maintenanceId}/{employeeId}", method = RequestMethod.PUT)
        public void assignEmployee(@PathVariable int employeeId, @PathVariable int maintenanceId) {
            maintenanceDao.assignEmployeeToRequest(employeeId, maintenanceId);
        }

        @RequestMapping(path ="/newTicket", method = RequestMethod.POST)
        public void createMaintenanceRequest(Principal principal, @RequestBody Maintenance maintenance) {
            User user = userDao.findByUsername(principal.getName());
            Tenant tenant = tenantDao.getTenant(user.getId());
            System.out.println(maintenance.toString());
            maintenanceDao.createMaintenanceRequest(tenant.getTenantId(), maintenance);
        }

        @RequestMapping(path="/listOfMaintenanceRequests", method = RequestMethod.GET)
        public List<Maintenance> getMaintenanceByLandlord(Principal principal) {
            User user = userDao.findByUsername(principal.getName());
            Landlord landlord = landlordDao.getLandlord(user.getId());
            return maintenanceDao.maintenanceRequestByLandlord(landlord.getLandlordId());
        }
    }

