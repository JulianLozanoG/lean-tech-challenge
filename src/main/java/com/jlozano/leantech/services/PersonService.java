package com.jlozano.leantech.services;

import com.jlozano.leantech.entities.Person;

import java.util.List;

public interface PersonService {
    Person createPerson(Person person);
    Person getPerson(Integer idPerson);
    List<Person> getPersons();
    void deletePerson(Integer idPerson);
}
