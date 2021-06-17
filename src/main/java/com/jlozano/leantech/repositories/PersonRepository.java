package com.jlozano.leantech.repositories;

import com.jlozano.leantech.entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    List<Person> findAll();
    Person getPersonById(Integer personId);
}
