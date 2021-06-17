package com.jlozano.leantech.controllers.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jlozano.leantech.entities.Position;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PositionsResponse {
    @JsonProperty("positions")
    private final List<Position> positions;
}
