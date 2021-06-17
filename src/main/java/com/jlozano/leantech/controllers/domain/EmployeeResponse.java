package com.jlozano.leantech.controllers.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jlozano.leantech.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeResponse {
    @JsonProperty("employee")
    private final Employee employee;
}
