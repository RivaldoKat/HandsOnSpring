package com.example.thymeleafdemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Student {

    private String firstName;

    private String lastName;

    private String country;

    private String programming;

    private List<String> operatingSys;

}
