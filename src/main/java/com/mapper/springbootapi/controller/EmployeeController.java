package com.mapper.springbootapi.controller;

import com.mapper.springbootapi.service.DbEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {


    private DbEmployee dbEmployee;

    @Autowired
    public EmployeeController(DbEmployee dbEmployee) {
        this.dbEmployee = dbEmployee;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("employeesList", dbEmployee.getAllEmployees());
        return "index";
    }

}
