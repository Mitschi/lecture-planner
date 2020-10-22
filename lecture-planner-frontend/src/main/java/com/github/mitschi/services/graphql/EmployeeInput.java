package com.github.mitschi.services.graphql;

import com.github.mitschi.models.Employee;

/**
 * This class is used as DTO for GraphQL.
 */
class EmployeeInput {
    private String name;
    private int employeeNumber;

    public EmployeeInput(String name, int employeeNumber) {
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

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public static EmployeeInput fromEmployee(Employee e){
        return new EmployeeInput(e.getName(), e.getEmployeeNumber());
    }
}
