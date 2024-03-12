package io.github.raulcfr112.restwithspringboot.services;

import io.github.raulcfr112.restwithspringboot.exceptions.ResourceNotFoundException;
import io.github.raulcfr112.restwithspringboot.model.Person;
import io.github.raulcfr112.restwithspringboot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        logger.info("Finding all person!");
        return repository.findAll();
    }

    public Person findByID(Long id) {

        logger.info("Finding one person!");

        Person person = new Person();
        person.setFirstName("Raul");
        person.setLastName("Camargo");
        person.setAddress("Coxinha");
        person.setGender("Omi");
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one person!");

        Person entity = repository.findById(person.getId()).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");
        Person entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }


}
