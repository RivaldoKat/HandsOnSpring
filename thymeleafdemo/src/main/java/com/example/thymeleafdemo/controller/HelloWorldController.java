package com.example.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need a controller method to show initial HTML form
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworldForm";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloWorld";
    }


    @GetMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {


        // convert the data to all caps
        theName = theName.toUpperCase();

        // create message
        String result = "Hey my friend " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloWorld";
    }
}
