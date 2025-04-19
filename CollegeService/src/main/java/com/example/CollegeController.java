package com.example;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CollegeController {

    @Autowired
    RestTemplate restTemplate;

    private static final String COLLEGE_SERVICE = "collegeService";

    int i = 0;

    @GetMapping("/college/student")
    //@Retry(name = COLLEGE_SERVICE, fallbackMethod = "getDefaultStudentName")
    @CircuitBreaker(name = COLLEGE_SERVICE, fallbackMethod = "getDefaultStudentName")
    public String getStudentName(){
        i = i + 1;
        System.out.println("Attempt Number----:"+i);
        String url = "http://localhost:6603/getStudentName";
        return restTemplate.getForObject(url , String.class);
    }

    public String getDefaultStudentName(Exception ex){
        return "Default Ravikumar Lakkakula from CircuitBreker";
    }
}
