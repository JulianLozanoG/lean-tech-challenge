package com.jlozano.leantech.controllers;

import com.jlozano.leantech.controllers.domain.PersonResponse;
import com.jlozano.leantech.entities.Person;
import com.jlozano.leantech.services.PersonService;
import com.jlozano.leantech.util.Utilities;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.jlozano.leantech.util.Utilities.FakePerson;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonPostControllerTest {
    private static final String URI_POST_PERSON = "/person";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService mockPersonService;

    @Test
    void post_person_request_should_return_200_when_insert_successfully() throws Exception {

        when(mockPersonService.createPerson(any(Person.class))).thenReturn(FakePerson.get());
    }
}
