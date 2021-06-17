package com.jlozano.leantech.controllers;

import com.jlozano.leantech.services.PersonService;
import com.jlozano.leantech.util.Utilities.FakePerson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.jlozano.leantech.util.Utilities.ONCE;
import static com.jlozano.leantech.util.Utilities.PERSON_ID;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
class PersonGetControllerTest {

    private static final String URI_GET_PERSON = "/person/{personId}";
    private static final String URI_GET_PERSONS = "/person";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService mockPersonService;

    @Test
    void get_persons_should_return_200_when_person_exists() throws Exception {
        when(mockPersonService.getPersons()).thenReturn(FakePerson.getPersonList());

        mockMvc.perform(get(URI_GET_PERSONS)
            .contentType(APPLICATION_JSON))
            .andExpect(status().isOk())
            .andDo(print());

        verify(mockPersonService, times(ONCE)).getPersons();
    }

    @Test
    void get_person_should_return_200_when_person_exists() throws Exception {
        when(mockPersonService.getPerson(eq(PERSON_ID))).thenReturn(FakePerson.get());

        mockMvc.perform(get(URI_GET_PERSON, PERSON_ID)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        verify(mockPersonService, times(ONCE)).getPerson(eq(PERSON_ID));
    }

    @Test
    void get_person_should_return_404_when_person_does_not_exists() throws Exception {
        when(mockPersonService.getPerson(eq(PERSON_ID))).thenReturn(null);

        mockMvc.perform(get(URI_GET_PERSON, PERSON_ID)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(print());

        verify(mockPersonService, times(ONCE)).getPerson(eq(PERSON_ID));
    }
}
