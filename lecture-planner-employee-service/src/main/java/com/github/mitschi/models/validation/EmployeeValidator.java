package com.github.mitschi.models.validation;

import com.github.mitschi.models.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class EmployeeValidator {

    public boolean isEmployeeValid(Employee e) {
        return e != null
                && isNameValid(e.getName())
                && isEmployeeNumberValid(e.getEmployeeNumber());
    }

    public boolean isNameValid(String name) {
        return name != null && !name.isEmpty();
    }

    public boolean isEmployeeNumberValid(int number) {
        return number > 0;
    }
}
