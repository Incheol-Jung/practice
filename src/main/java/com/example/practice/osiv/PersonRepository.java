package com.example.practice.osiv;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Incheol Jung
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {}
