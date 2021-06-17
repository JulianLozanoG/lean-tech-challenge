package com.jlozano.leantech.services.impl;

import com.jlozano.leantech.entities.Person;
import com.jlozano.leantech.repositories.PersonRepository;
import com.jlozano.leantech.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {
        personRepository.save(person);
        return person;
    }

    @Override
    public Person getPerson(Integer idPerson) {
        return personRepository.getPersonById(idPerson);
    }

    @Override
    public List<Person> getPersons() {
        return personRepository.findAll();
    }

    @Override
    public void deletePerson(Integer idPerson) {
        personRepository.deleteById(idPerson);
    }
}
