package com.github.mitschi.services;

import com.github.mitschi.models.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private final RestTemplate restTemplate;

    @Value("${endpoint.employee}")
    private String employeesEndpointUrl;

    public EmployeeService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public Employee[] getEmployees() throws RestClientException {
        return restTemplate.getForObject(employeesEndpointUrl, Employee[].class);
    }

    public Employee getEmployeeById(Integer id) throws RestClientException {
        return restTemplate.getForObject(employeesEndpointUrl+"/"+id, Employee.class);
    }

    public ResponseEntity<Employee> addEmployee(Employee e) {
        return restTemplate.postForEntity(employeesEndpointUrl, e, Employee.class);
    }
}
