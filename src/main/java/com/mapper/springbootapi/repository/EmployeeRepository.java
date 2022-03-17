package com.mapper.springbootapi.repository;

import com.mapper.springbootapi.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    List<Employee> findAll();

    Optional<Employee> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    Employee save(Employee employee);
}
