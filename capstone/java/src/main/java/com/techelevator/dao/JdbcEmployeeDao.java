package com.techelevator.dao;

import com.techelevator.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;


@Component
public class JdbcEmployeeDao implements EmployeeDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcEmployeeDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean addEmployee(String firstname, String lastname, String phone, String email, int userId) {
        String insertUserSql = "INSERT INTO employee (employee_name, emp_phone, emp_email,  employee_user_id) values (?,?,?,?)";
        return jdbcTemplate.update(insertUserSql, "" + firstname + " " + lastname, phone, email, userId) == 1;
    }

    @Override
    public Employee getEmployee(int employeeId) {
        Employee employee = null;
        String sql = "SELECT employee_id, employee_name, emp_email, emp_phone " +
                "FROM employee " +
                "WHERE employee_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, employeeId);
        if (results.next()) {
            employee = mapRowToEmployee(results);
        }
        return employee;
    }

    @Override
    public ArrayList<Employee> listOfEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";
        SqlRowSet returnedEmployees = jdbcTemplate.queryForRowSet(sql);
        while (returnedEmployees.next()) {
            employees.add(mapRowToEmployee(returnedEmployees));
        }
        return employees;
    }


    private Employee mapRowToEmployee(SqlRowSet rowSet) {
        Employee employee = new Employee();
        employee.setEmployeeId(rowSet.getInt("employee_id"));
        employee.setEmployeeName(rowSet.getString("employee_name"));
        employee.setEmployeePhone(rowSet.getString("emp_phone"));
        employee.setEmployeeEmail(rowSet.getString("emp_email"));

        return employee;
    }
}
