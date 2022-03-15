package com.mapper.springbootapi.repository;

import com.mapper.springbootapi.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

    @Override
    void deleteById(Long id);

    @Override
    Employee save(Employee employee);
}
