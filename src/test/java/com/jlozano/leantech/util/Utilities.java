package com.jlozano.leantech.util;

import com.jlozano.leantech.controllers.domain.PersonResponse;
import com.jlozano.leantech.entities.Person;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public final class Utilities {
    public static final int ONCE = 1;
    public static final int PERSON_ID = 1;
    public static final String ADDRESS = "40 STREET";
    public static final String CELLPHONE = "3145675654";
    public static final String CITY_NAME = "BOGOTA";
    public static final String NAME = "JULIAN";
    public static final String LASTNAME = "LOZANO";

    public static final class FakePerson {

        public static Person get() {
            Person person = new Person();
            person.setAddress(ADDRESS);
            person.setCellphone(CELLPHONE);
            person.setCityName(CITY_NAME);
            person.setName(NAME);
            person.setLastName(LASTNAME);

            return person;
        }

        public static List<Person> getPersonList() {
            Person person = FakePerson.get();
            List<Person> personList = new ArrayList<>();
            personList.add(person);
            return personList;
        }

        public static final class FakePersonResponse {
            public static PersonResponse get() {return new PersonResponse(FakePerson.get());}
        }
    }
}
