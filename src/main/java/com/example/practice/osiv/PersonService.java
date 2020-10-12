package com.example.practice.osiv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Incheol Jung
 */
@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    TeamRepository teamRepository;

    @Transactional
    public Person get(int id){
        return personRepository.findById(id).get();
    }

    public void save() {
        Team team = new Team();
        teamRepository.save(team);
        personRepository.save(new Person("incheol",team));
    }
}
