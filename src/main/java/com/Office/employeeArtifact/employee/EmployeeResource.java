package com.Office.employeeArtifact.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public class EmployeeResource {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/students/{id}")
    public Employee retrieveEmployee(@PathVariable long id) {
        Optional<Employee> student = employeeRepository.findById(id);

        if (!student.isPresent())
            throw new EmployeeNotFoundException("id-" + id);

        return student.get();
    }
}
