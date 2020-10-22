package com.github.mitschi.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.github.mitschi.models.Employee;
import com.github.mitschi.models.dto.EmployeeInput;
import com.github.mitschi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private EmployeeService employeeService;

    public Employee createEmployee(EmployeeInput input) {
        return employeeService.addEmployee(createEmployeeFromInput(input));
    }

    public Employee updateEmployee(long id, EmployeeInput input) {
        Employee e = createEmployeeFromInput(input);
        employeeService.updateEmployee(id, e);
        return e;
    }

    public int deleteEmployee(long id) {
        employeeService.deleteEmployee(id);
        // TODO error handling
        return 1;
    }

    private Employee createEmployeeFromInput(EmployeeInput input) {
        return new Employee(input.getName(), input.getEmployeeNumber());
    }

}
