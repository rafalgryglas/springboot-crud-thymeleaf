package com.mapper.springbootapi.controller;

import com.mapper.springbootapi.domain.Employee;
import com.mapper.springbootapi.service.DbEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {


    private final DbEmployee dbEmployee;

    @Autowired
    public EmployeeController(DbEmployee dbEmployee) {
        this.dbEmployee = dbEmployee;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("employeesList", dbEmployee.getAllEmployees());
        return "index";
    }

    @GetMapping("add-employee")
    public String addEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new-employee";
    }

    @PostMapping("save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        dbEmployee.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("update/{id}")
    public String updateEmployee(@PathVariable(value = "id") long id, Model model) throws EmployeeNotFoundException {
        Employee employee = dbEmployee.getEmployeeById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        model.addAttribute("employee", employee);
        return "update-employee";
    }

    @GetMapping("delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        dbEmployee.deleteEmployee(id);
        return "redirect:/";
    }

    @GetMapping("/employees-for-user")
    public String homePageForUsers(Model model) {
        model.addAttribute("employeesList", dbEmployee.getAllEmployees());
        return "employees-for-user";
    }
}
