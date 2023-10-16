package com.techelevator.dao;

import com.techelevator.model.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeDao {



        ArrayList<Employee> listOfEmployees();

//    MORE STUFF SOON!


    Employee getEmployee(int employeeId);
    boolean addEmployee(String firstname, String lastname, String email, String phone, int userId);
    
    }

