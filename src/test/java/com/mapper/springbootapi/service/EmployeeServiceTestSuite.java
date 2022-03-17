package com.mapper.springbootapi.service;

import com.mapper.springbootapi.domain.Employee;
import com.mapper.springbootapi.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
public class EmployeeServiceTestSuite {

    @MockBean
    private EmployeeRepository employeeRepository;

    @Autowired
    private DbEmployee dbEmployee;

    @Test
    public void getAllEmployeeTest(){
        //Given
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(5L,"Raf", "Gryg", 8812169845L,"raf@rag.com"));
        employees.add(new Employee(6L,"Rafas", "Grygss", 881216985L,"raf@ag.com"));
        when(employeeRepository.findAll()).thenReturn(employees);
        //When
        List<Employee> resultList = dbEmployee.getAllEmployees();
        //Then
        assertEquals(2,resultList.size());
    }
    @Test
    public void getEmployeeByIdTest() {
        //Given
        Employee employee = new Employee(5L,"Rafal", "Gryglas", 8812169845L,"raf@rag.com");
        when(employeeRepository.findById(5L)).thenReturn(Optional.of(employee));
        //When
        Optional<Employee> result = dbEmployee.getEmployeeById(5L);
        //Then
        assertEquals("Rafal",result.get().getFirstName());
    }
    @Test
    public void saveEmployeeTest() {
        //Given
        Employee employee = new Employee(5L,"Rafal", "Gryglas", 8812169845L,"raf@rag.com");
        when(employeeRepository.save(employee)).thenReturn(employee);
        //When
        Employee resultEmployee = dbEmployee.saveEmployee(employee);
        //Then
        assertEquals("Gryglas", resultEmployee.getLastName());
    }
}
