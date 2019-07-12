package io.zipcoder.crudapp.Controller;

import io.zipcoder.crudapp.Models.Person;

import io.zipcoder.crudapp.Repositories.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonController personController;



    @Test
    public void createPerson() {
        Person person1 = createPersonMock();
        when(personController.createPerson(person1)).thenReturn(person1);
        personController.createPerson(person1);


        verify(personRepository, times(1)).save(person1);


    }

    @Test
    public void getPerson() {
        Person person = createPersonMock();
        when(personController.getPerson(1)).thenReturn(subData().get(1));
        personController.getPerson(1);
        verify(personRepository, times(1)).findOne(1);

    }

    @Test
    public void getPersonList() {
        when(personController.getPersonList()).thenReturn(subData());
        personController.getPersonList();
        verify(personRepository, times(1)).findAll();

    }

    @Test
    public void updatePerson() {
        Person person = subData().get(1);


        Person personUpdate =  person;
        personUpdate.setFirstName("Bob");
        personController.createPerson(person);

        when(personController.updatePerson(person, 1)).thenReturn(personUpdate);
        personController.updatePerson(person, 1);
        verify(personRepository, times(1)).save(personUpdate);

    }

    @Test
    public void deletePerson() {
    }

    @Test
    public void findAll (){
        when(personController.getPersonList()).thenReturn(subData());
        personController.getPersonList();
        verify(personRepository,times(1)).findAll();
    }


    private List<Person> subData() {
        Person person1 = new Person("Ben", "C");
        Person person2 = new Person("Charles", "bro");

        return Arrays.asList(person1, person2);
    }


    private Person createPersonMock(){
        Person person1 = new Person ("Ben", "C");

        return person1;
    }
}