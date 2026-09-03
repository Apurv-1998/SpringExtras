package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public String getEmployees(HttpServletRequest request) {

        String department = request.getParameter("department");
        String location = request.getParameter("location");

        /*
            value -> String[] -> because my request parameter can appear multiple times -> ?color='black'&color='pink'
        */
        Map<String,String[]> reqMap = request.getParameterMap();

        for(Map.Entry<String,String[]> entry : reqMap.entrySet()){
            String paramName = entry.getKey();
            String[] values = entry.getValue();

            System.out.println(paramName);

            for (String value : values){
                System.out.println(value);
            }
        }

        return department + " " + location;
    }
}
