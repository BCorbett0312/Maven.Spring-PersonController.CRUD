package io.zipcoder.crudapp.Controller;

import io.zipcoder.crudapp.Models.Person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import java.util.Arrays;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

    @Mock
    private PersonController personController;




    @Test
    public void createPerson() {
        when(personController.createPerson(createPersonMock())).thenReturn(createPersonMock());
        personController.createPerson(createPersonMock());


        verify(personController, times(1)).createPerson(createPersonMock());


    }

    @Test
    public void getPerson() {
    }

    @Test
    public void getPersonList() {
    }

    @Test
    public void updatePerson() {
    }

    @Test
    public void deletePerson() {
    }

    @Test
    public void findAll (){
        when(personController.getPersonList()).thenReturn(subData());
        personController.getPersonList();
        verify(personController,times(1)).getPersonList();
    }

    private Iterable<Person> subData() {
        Person person1 = new Person("Ben", "C");
        Person person2 = new Person("Charles", "bro");

        return Arrays.asList(person1, person2);
    }


    private Person createPersonMock(){
        Person person1 = new Person ("Ben", "C");

        return person1;
    }
}