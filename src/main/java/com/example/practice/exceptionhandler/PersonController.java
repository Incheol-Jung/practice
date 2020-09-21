package com.example.practice.exceptionhandler;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Incheol Jung
 */
@Controller
@RequestMapping("/person")
public class PersonController {
    @InitBinder
    public void InitBinder(WebDataBinder dataBinder) {
        System.out.println("test!!!!");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        dataBinder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, true));
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("msg", "Welcome to the Netherlands!");
    }

//    @GetMapping("model")
//    public String modelTest(){
//
//    }

    @GetMapping("register")
    public String register(@ModelAttribute Person person){
        System.out.println(person.toString());
        return "hello";
    }

//    @PostMapping
//    public String register(@RequestBody Person person){
//        return person.toString();
//    }

    @GetMapping
    public String test(){
        return "test";
    }

    @GetMapping("/exception")
    public String exception1(){
        throw new NullPointerException();
    }

    @GetMapping("/exception2")
    public String exception2(){
        throw new ClassCastException();
    }

    @ExceptionHandler({NullPointerException.class, ClassCastException.class})
    public String handle(Exception ex){
        return "Exception Handle!!!";
    }
}
