package com.jlozano.leantech.controllers.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jlozano.leantech.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PersonResponse {
    @JsonProperty("person")
    private final Person person;
}
