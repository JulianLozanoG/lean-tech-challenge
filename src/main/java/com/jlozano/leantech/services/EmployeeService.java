package com.jlozano.leantech.services;

import com.jlozano.leantech.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    Employee getEmployee(Integer employeeId);
    List<Employee> getEmployeeByPositionAndPerson(String positionName, String personName);
    List<Employee> getEmployees();
    void deleteEmployee(Integer employeeId);
    Employee updateEmployee(Employee employee, Integer employeeId);
}
