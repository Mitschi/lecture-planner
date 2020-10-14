package com.github.mitschi.controllers;

import com.github.mitschi.ResourceNotFoundException;
import com.github.mitschi.models.Employee;
import com.github.mitschi.repositories.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping()
    public List<Employee> listEmployees() {
        return employeeDao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id)
            throws ResourceNotFoundException {

        Employee l = employeeDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for id: " + id));
        return ResponseEntity.ok(l);
    }

    @PostMapping()
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeDao.save(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,
                                                 @Valid @RequestBody Employee employeeDto)
            throws ResourceNotFoundException {

        Employee origEmployee = employeeDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for id: " + id));

        origEmployee.updateFromDto(employeeDto);

        Employee updatedEmployee = employeeDao.save(origEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable("id") Long id)
            throws ResourceNotFoundException {

        Employee origEmployee = employeeDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for id: " + id));

        employeeDao.delete(origEmployee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
