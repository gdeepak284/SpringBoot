package com.Office.employeeArtifact.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

public class EmployeeResource {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees/{id}")
    public Employee retrieveEmployee(@PathVariable long id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (!employee.isPresent())
            throw new EmployeeNotFoundException("id-" + id);

        return employee.get();
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable long id) {
        employeeRepository.deleteById(id);
    }

    @PostMapping("/employees")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeRepository.save(employee);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedEmployee.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable long id) {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);

        if (!employeeOptional.isPresent())
            return ResponseEntity.notFound().build();

        employee.setId(id);

        employeeRepository.save(employee);

        return ResponseEntity.noContent().build();
    }
}
