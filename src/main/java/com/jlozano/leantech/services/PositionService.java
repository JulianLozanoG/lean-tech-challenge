package com.jlozano.leantech.services;


import com.jlozano.leantech.entities.Position;

import java.util.List;

public interface PositionService {
    List<Position> getPositionsOrderByEmployeesDesc();
    List<Position> getPositions();
}
