package com.jlozano.leantech.controllers;

import com.jlozano.leantech.controllers.domain.EmployeeResponse;
import com.jlozano.leantech.entities.Employee;
import com.jlozano.leantech.exceptions.EmployeeNotFoundException;
import com.jlozano.leantech.services.EmployeeService;
import io.swagger.annotations.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;
import static org.springframework.http.ResponseEntity.ok;

@Api(tags = {"Employee"})
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeePutController {
    private final EmployeeService employeeService;

    @ApiOperation(value = "Updates a single Employee", response = EmployeeResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = EmployeeResponse.class),
            @ApiResponse(code = 400, message = "Bad request, adjust parameters before retrying"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PutMapping(value = "/{employeeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponse> updateEmployee(
            @ApiParam(value = "ID for the Employee.", required = true)
            @Pattern(regexp = "^[0-9]{4}", message = "The Employee ID should contain only numeric characters and its length si not mayor than 4.")
            @PathVariable Integer employeeId,

            @RequestBody
            @Valid Employee employeeRequest) {

        Employee employee = employeeService.getEmployee(employeeId);
        if (isNull(employee))
            throw new EmployeeNotFoundException("Employee not found");

        employeeService.updateEmployee(employeeRequest, employeeId);

        return ok(new EmployeeResponse(employee));
    }
}
