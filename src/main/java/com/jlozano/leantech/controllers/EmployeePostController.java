package com.jlozano.leantech.controllers;

import com.jlozano.leantech.controllers.domain.EmployeeResponse;
import com.jlozano.leantech.entities.Employee;
import com.jlozano.leantech.services.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@Api(tags = {"Employee"})
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/employee")
public class EmployeePostController {
    private final EmployeeService employeeService;

    @ApiOperation(value = "Creates a single Employee", response = EmployeeResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = EmployeeResponse.class),
            @ApiResponse(code = 400, message = "Bad request, adjust parameters before retrying"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeResponse> createEmployee(
            @RequestBody
            @Valid Employee employeeRequest) {
        return ok(new EmployeeResponse(employeeService.createEmployee(employeeRequest)));
    }
}
