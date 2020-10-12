package com.example.practice.osiv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Incheol Jung
 */
@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping
    public String get(){
        Person person = personService.get(1);
        Team team = person.getTeam();
        System.out.println(team.getName());
        return "person";
    }

    @PostMapping
    public void save(){
        personService.save();
    }
}
