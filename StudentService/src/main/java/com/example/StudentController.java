package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/getStudentName")
    public String getName(){
        return "Ravikumar Lakkakula";
    }
}
