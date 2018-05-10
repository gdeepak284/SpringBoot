package com.Office.employeeArtifact.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository implements JpaRepository<Employee, Long> { {
}
