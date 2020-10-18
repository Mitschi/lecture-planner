package com.github.mitschi.services;

import com.github.mitschi.models.Employee;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

    private final RestTemplate restTemplate;
    private final String employeesEndpointUrl = "http://localhost:8081/employees";

    public EmployeeService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public Employee[] getEmployees(){
        return restTemplate.getForObject(employeesEndpointUrl, Employee[].class);
    }

    public ResponseEntity<Employee> addEmployee(Employee e) {
        return restTemplate.postForEntity(employeesEndpointUrl, e, Employee.class);
    }
}
