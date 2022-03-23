package com.mapper.springbootapi.repository;

import com.mapper.springbootapi.domain.Employee;
import com.mapper.springbootapi.domain.User;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

//add users and employees at the start app
@Repository
public class EmployeeAndUserDao {

    private JdbcTemplate jdbcTemplate;

    private UserRepository userRepository;

    public EmployeeAndUserDao(JdbcTemplate jdbcTemplate, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRepository = userRepository;

        User adminUser = new User();
        adminUser.setUsername("rafal");
        adminUser.setPassword(passwordEncoder.encode("admin"));
        adminUser.setRole("ROLE_ADMIN");
        userRepository.save(adminUser);

        User user = new User();
        user.setUsername("noname");
        user.setPassword(passwordEncoder.encode("noname"));
        user.setRole("ROLE_USER");
        userRepository.save(user);
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
