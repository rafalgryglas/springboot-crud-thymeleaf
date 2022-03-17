package com.mapper.springbootapi.repository;

import com.mapper.springbootapi.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void employeeRepositoryTest() {
        //Given
        Employee employee = new Employee(5L,"Rafal", "Gryg", 8812169845L,"raf@rag.com");
        //When
        employeeRepository.save(employee);
        Long id = employee.getId();
        Optional<Employee> getEmployee = employeeRepository.findById(id);
        //Then
        assertEquals(id, getEmployee.get().getId());
        //CleanUp
        employeeRepository.deleteById(id);
    }
}
