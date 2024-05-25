package com.example.validationdemo;

import com.example.validationdemo.validation.CourseCode;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Customer {

    private String firstName;

    @NotNull(message="is required")
    @Size(min=1, message="is required")
    private String lastName;

    @NotNull(message="is required")
    @Min(value = 0, message = "must be greater than 0")
    @Max(value = 10, message = "must be less than 10")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{4}", message = "only 5 chars/digits")
    private String postalCode;

    @CourseCode
    private String courseCode;

}
