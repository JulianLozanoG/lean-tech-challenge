package com.jlozano.leantech.controllers;

import com.jlozano.leantech.controllers.domain.PersonResponse;
import com.jlozano.leantech.entities.Person;
import com.jlozano.leantech.services.PersonService;
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

@Api(tags = {"Persons"})
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/person")
public class PersonPostController {
    private final PersonService personService;

    @ApiOperation(value = "Creates a single Person", response = PersonResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ok", response = PersonResponse.class),
            @ApiResponse(code = 400, message = "Bad request, adjust parameters before retrying"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> createPerson(
            @RequestBody
            @Valid Person personRequest) {

        return ok(new PersonResponse(personService.createPerson(personRequest)));
    }
}
