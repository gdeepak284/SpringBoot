package com.Office.employeeArtifact.employee;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "passportnumber")
    private String passportNumber;

    public Employee() {
        super();
    }

    public Employee(Long id, String name, String passportNumber) {
        super();
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassportNumber() {
        return passportNumber;
    }
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

}

