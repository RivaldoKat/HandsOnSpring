package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${programming}")
    private List<String> programming;

    @Value("${operatingSys}")
    private List<String> operatingSys;

    @GetMapping("/showStudentForm")
    public String showForm(Model model) {

        // create a student object
        Student theStudent = new Student();

        // add student object to the model
        model.addAttribute("student", theStudent);

        // add the list of countries to the model
        model.addAttribute("countries", countries);

        // add the list of programming languages to the model
        model.addAttribute("programming", programming);

        // add the list of programming languages to the model
        model.addAttribute("operatingSys", operatingSys);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

        // log the input data
        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";
    }
}
