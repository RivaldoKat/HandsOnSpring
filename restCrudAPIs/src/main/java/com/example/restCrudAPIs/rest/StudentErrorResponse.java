package com.example.restCrudAPIs.rest;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentErrorResponse {

    private int status;

    private String message;

    private Long timeStamp;

}
