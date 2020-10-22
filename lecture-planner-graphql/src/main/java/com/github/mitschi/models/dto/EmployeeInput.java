package com.github.mitschi.models.dto;

public class EmployeeInput {
    private String name;
    private Integer employeeNumber;

    public EmployeeInput(String name, Integer employeeNumber) {
        this.name = name;
        this.employeeNumber = employeeNumber;
    }

    public EmployeeInput() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
}
