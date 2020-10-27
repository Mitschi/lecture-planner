package com.github.mitschi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int employeeNumber;

    public Employee(){
    }

    public Employee(Long id, String name, int employeeNumber) {
        this.id = id;
        this.name = name;
        this.employeeNumber = employeeNumber;
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

    public int getEmployeeNumber() {
        return employeeNumber;
    }
    public void setEmployeeNumber(int age) {
        this.employeeNumber = age;
    }

    public void updateFromDto(Employee other) {
        this.setName(other.getName());
        this.setEmployeeNumber(other.getEmployeeNumber());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", employeeNumber=" + employeeNumber + '\'' +
                '}';
    }
}
