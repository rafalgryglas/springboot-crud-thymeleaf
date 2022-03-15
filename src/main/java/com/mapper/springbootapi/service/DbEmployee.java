package com.mapper.springbootapi.service;

import com.mapper.springbootapi.domain.Employee;
import com.mapper.springbootapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbEmployee {

    private EmployeeRepository repository;

    @Autowired
    public DbEmployee(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public void deleteEmployee(final Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Employee seveEmpolyee(final Employee employee) {
        return repository.save(employee);
    }
}
