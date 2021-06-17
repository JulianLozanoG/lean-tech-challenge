package com.jlozano.leantech.repositories;

import com.jlozano.leantech.entities.Position;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Integer> {
    @Override
    List<Position> findAll(Sort sort);
}
