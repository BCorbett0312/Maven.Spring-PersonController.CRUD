package io.zipcoder.crudapp.Controller;

import io.zipcoder.crudapp.Models.Person;
import io.zipcoder.crudapp.Repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



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

        return this.personRepository.findAll();
    }

    @PutMapping(value = "/people")
    public Person updatePerson(@RequestBody Person p){
        return this.personRepository.save(p);
    }

    @DeleteMapping(value = "/people/{id}")
    public void deletePerson(@PathVariable int id){
        this.personRepository.delete(id);
    }


}
