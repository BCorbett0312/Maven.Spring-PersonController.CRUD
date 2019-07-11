package io.zipcoder.crudapp.Controller;

import io.zipcoder.crudapp.Models.Person;
import io.zipcoder.crudapp.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    public PersonController(PersonRepository personRepository){this.personRepository=personRepository;}

    @PostMapping(value = "/people")
    public Person createPerson(@RequestBody Person p){
        return this.personRepository.save(p);
    }

    @GetMapping(value = "/people/{id}")
    public Person getPerson(@PathVariable int id){
        return this.personRepository.findOne(id);
    }

    @GetMapping(value = "/people")
    public Iterable<Person> getPersonList(){

        //ist<Person> personList = personRepository.findAll();


        return this.personRepository.findAll();
    }

    @PutMapping(value = "/people/{id}")
    public Person updatePerson(Person p, @PathVariable int id){
        Person old = getPerson(id);
        old.setFirstName(p.getFirstName());
        old.setLastName(p.getLastName());



        return this.personRepository.save(old);
    }

    @DeleteMapping(value = "/people/{id}")
    public void deletePerson(@PathVariable int id){
        this.personRepository.delete(id);
    }


}
