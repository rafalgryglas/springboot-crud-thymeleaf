package com.mapper.springbootapi.repository;

import com.mapper.springbootapi.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employee VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]{
                employee.getId(),
                employee.getEmail(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPesel()
        });
    }

    @EventListener(ApplicationReadyEvent.class)
    public void dbAddWhenInit() {
        addEmployee(new Employee(1L, "Rafal", "Gryglas", 88111111111L, "rafal@gryglas.com"));
        addEmployee(new Employee(2L, "No", "Name", 88104126498L, "no@name.com"));
        addEmployee(new Employee(3L, "Anna", "Smith", 88050526498L, "anna@smith.com"));
        addEmployee(new Employee(4L, "John", "Rambo", 47548226498L, "john@rambo.com"));
    }


}
