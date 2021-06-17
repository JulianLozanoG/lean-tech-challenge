package com.jlozano.leantech.controllers.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jlozano.leantech.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EmployeesResponse {
    @JsonProperty("employees")
    private final List<Employee> employees;
}
