package com.jlozano.leantech.services.impl;

import com.jlozano.leantech.entities.Position;
import com.jlozano.leantech.repositories.PositionRepository;
import com.jlozano.leantech.services.PositionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    EntityManagerFactory emf;

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<Position> getPositionsOrderByEmployeesDesc() {
        Query query = getEntityManager().createNamedQuery("Position.findAllOrderByEmployeeDesc");
        return  (List<Position>) query.getResultList();
    }

    @Override
    public List<Position> getPositions() {
        return positionRepository.findAll();
    }
}
