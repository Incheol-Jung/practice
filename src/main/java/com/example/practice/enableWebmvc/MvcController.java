package com.example.practice.enableWebmvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Incheol Jung
 */
@RestController()
public class MvcController {
    @GetMapping(value = "/mvc/test")
    public String test(){
        return "test";
    }
}
