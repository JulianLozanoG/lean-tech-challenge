package com.jlozano.leantech.repositories;

import com.jlozano.leantech.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Override
    List<Employee> findAll();
    Employee getEmployeeById(Integer employeeId);
    List<Employee> findEmployeeByPerson_Name(String personName);
    List<Employee> findEmployeeByPosition_Name(String positionName);
    List<Employee> findEmployeeByPosition_NameAndPerson_Name(String positionName, String personName);
}
