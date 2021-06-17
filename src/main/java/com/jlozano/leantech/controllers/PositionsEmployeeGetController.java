package com.jlozano.leantech.controllers;

import com.jlozano.leantech.controllers.domain.EmployeeResponse;
import com.jlozano.leantech.controllers.domain.PositionsResponse;
import com.jlozano.leantech.services.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@Api(tags = {"Positions"})
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/position/employee")
public class PositionsEmployeeGetController {
    private final PositionService positionService;

    @ApiOperation(value = "Get a list of Positions related with Employees created in the system", response = PositionsResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = PositionsResponse.class),
            @ApiResponse(code = 400, message = "Bad request, adjust parameters before retrying"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PositionsResponse> getPositionsOrderByEmployeesDec() {
        return ok(new PositionsResponse(positionService.getPositionsOrderByEmployeesDesc()));
    }
}
