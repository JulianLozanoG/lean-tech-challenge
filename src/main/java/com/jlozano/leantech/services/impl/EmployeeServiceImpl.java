package com.jlozano.leantech.services.impl;

import com.jlozano.leantech.entities.Employee;
import com.jlozano.leantech.exceptions.EmployeeNotFoundException;
import com.jlozano.leantech.repositories.EmployeeRepository;
import com.jlozano.leantech.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee getEmployee(Integer employeeId) {
        return employeeRepository.getEmployeeById(employeeId);
    }

    @Override
    public List<Employee> getEmployeeByPositionAndPerson(String positionName, String personName) {

        /*Predicate<Employee> employeePredicate = (e)->e.getPosition().getName().equals(positionName);
        employeePredicate.or((e->e.getPerson().getName().equals(personName)));*/
        if (!isNull(positionName) && !isNull(personName)) {
            if (!positionName.isEmpty() && !personName.isEmpty())
                return employeeRepository.findEmployeeByPosition_NameAndPerson_Name(positionName, personName);

            return employeeRepository.findAll();
        } else if (!isNull(positionName) && !positionName.isEmpty()) {
            return employeeRepository.findEmployeeByPosition_Name(positionName);
        } else if (!isNull(personName) && personName.isEmpty()) {
            return employeeRepository.findEmployeeByPerson_Name(personName);
        } else { return employeeRepository.findAll();}
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployee(Employee employee, Integer employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if (!employeeOptional.isPresent())
            throw new EmployeeNotFoundException("Employee not found");

        employee.setId(employeeId);
        employeeRepository.save(employee);
        return employee;
    }
}
