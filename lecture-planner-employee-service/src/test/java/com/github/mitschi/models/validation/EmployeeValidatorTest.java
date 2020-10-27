package com.github.mitschi.models.validation;

import com.github.mitschi.models.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmployeeValidatorTest {
    private EmployeeValidator validator;

    @Before
    public void setup(){
        validator = new EmployeeValidator();
    }

    @Test
    public void isNameValid_null_isInvalid(){
        boolean res = validator.isNameValid(null);
        Assert.assertFalse(res);
    }

    @Test
    public void isNameValid_emptyString_isInvalid(){
        boolean res = validator.isNameValid("");
        Assert.assertFalse(res);
    }

    @Test
    public void isNameValid_someName_isValid(){
        boolean res = validator.isNameValid("Peter");
        Assert.assertTrue(res);
    }

    @Test
    public void isNameValid_someLowercaseName_isValid(){
        boolean res = validator.isNameValid("peter");
        Assert.assertTrue(res);
    }

    @Test
    public void isNameValid_concatenatedNames_isValid(){
        boolean res = validator.isNameValid("Peter Müller");
        Assert.assertTrue(res);
    }

    @Test
    public void isEmployeeNumberValid_negativeNum_isInvalid(){
        // is -1 better than -5 ?
        boolean res = validator.isEmployeeNumberValid(-5);
        Assert.assertFalse(res);
    }

    @Test
    public void isEmployeeNumberValid_Zero_isInvalid(){
        boolean res = validator.isEmployeeNumberValid(0);
        Assert.assertFalse(res);
    }

    @Test
    public void isEmployeeNumberValid_posNum_isValid(){
        boolean res = validator.isEmployeeNumberValid(1);
        Assert.assertTrue(res);
    }

    @Test
    public void isEmployeeValid_null_isInvalid(){
        boolean res = validator.isEmployeeValid(null);
        Assert.assertFalse(res);
    }

    @Test
    public void isEmployeeValid_SomeEmployee_isValid(){
        Employee someEmployee = new Employee(0L, "peter", 1);
        boolean res = validator.isEmployeeValid(someEmployee);
        Assert.assertTrue(res);
    }
}
