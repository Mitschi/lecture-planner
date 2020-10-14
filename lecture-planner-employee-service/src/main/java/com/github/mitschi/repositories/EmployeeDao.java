package com.github.mitschi.repositories;

import com.github.mitschi.models.Employee;
import com.github.mitschi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
}
