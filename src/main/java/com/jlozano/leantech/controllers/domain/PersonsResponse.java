package com.jlozano.leantech.controllers.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jlozano.leantech.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PersonsResponse {
    @JsonProperty("persons")
    private final List<Person> persons;
}
