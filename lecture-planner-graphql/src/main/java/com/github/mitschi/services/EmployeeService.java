package com.github.mitschi.services;

import com.github.mitschi.models.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

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

    public Employee getEmployeeById(long id) throws RestClientException {
        return restTemplate.getForObject(employeesEndpointUrl + '/' + id, Employee.class);
    }

    public Employee addEmployee(Employee e) throws RestClientException {
        ResponseEntity<Employee> response = restTemplate.postForEntity(employeesEndpointUrl, e, Employee.class);
        return response.getBody();
    }

    public void updateEmployee(long id, Employee e) throws RestClientException {
        restTemplate.put(employeesEndpointUrl + '/' + id, e);
    }

    public void deleteEmployee(long id) throws RestClientException {
        restTemplate.delete(employeesEndpointUrl + '/' + id);
    }
}
