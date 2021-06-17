package com.jlozano.leantech.controllers;

import com.jlozano.leantech.entities.Person;
import com.jlozano.leantech.exceptions.EmployeeNotFoundException;
import com.jlozano.leantech.services.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.isNull;

@Api(tags = {"Persons"})
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonDeleteController {
    private final PersonService personService;

    @ApiOperation(value = "Deletes a Person identified by Person ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 400, message = "Bad request, adjust parameters before retrying"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @DeleteMapping(value = "/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletePerson(
            @ApiParam(value = "ID for the Person.", required = true)
            @Pattern(regexp = "^[0-9]{4}", message = "The Person ID should contain only numeric characters and its length is not mayor than 4.")
            @PathVariable Integer personId){
        Person person = personService.getPerson(personId);
        if (isNull(person)) {
            throw new EmployeeNotFoundException("Person not found");
        }
        personService.deletePerson(personId);
    }
}
