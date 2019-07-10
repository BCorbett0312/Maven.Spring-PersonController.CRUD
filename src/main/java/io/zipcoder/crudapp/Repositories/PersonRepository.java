package io.zipcoder.crudapp.Repositories;

import io.zipcoder.crudapp.Models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
