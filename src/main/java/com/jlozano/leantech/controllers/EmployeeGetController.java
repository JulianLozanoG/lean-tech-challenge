package com.jlozano.leantech.controllers;

import com.jlozano.leantech.controllers.domain.EmployeeResponse;
import com.jlozano.leantech.controllers.domain.EmployeesResponse;
import com.jlozano.leantech.entities.Employee;
import com.jlozano.leantech.exceptions.EmployeeNotFoundException;
import com.jlozano.leantech.services.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;
import static org.springframework.http.ResponseEntity.ok;

@Api(tags = {"Employees"})
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeeGetController {
    private final EmployeeService employeeService;

    @ApiOperation(value = "Get a list of Employees created in the system, a single Employee is identified by Person ID", response = EmployeeResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = EmployeeResponse.class),
            @ApiResponse(code = 400, message = "Bad request, adjust parameters before retrying"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping(value = "/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponse> getEmployee(
            @ApiParam(value = "ID for the Employee.", required = true)
            @Pattern(regexp = "^[0-9]{4}", message = "The Employee ID should contain only numeric characters and its length is not mayor than 4.")
            @PathVariable Integer employeeId){

        Employee employee = employeeService.getEmployee(employeeId);
        if (isNull(employee)) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        return ok(new EmployeeResponse(employee));
    }

    @GetMapping(params = {"positionName","personName"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeesResponse> getEmployeeByPositionAndPerson(
            @RequestParam(required = false) String positionName,
            @RequestParam(required = false) String personName){
        return ok(new EmployeesResponse(employeeService.getEmployeeByPositionAndPerson(positionName, personName)));
    }
}
