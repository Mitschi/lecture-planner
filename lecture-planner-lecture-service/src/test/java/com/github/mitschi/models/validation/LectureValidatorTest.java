package com.github.mitschi.models.validation;

import com.github.mitschi.models.Lecture;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LectureValidatorTest {
    private LectureValidator validator;

    @Before
    public void setup(){
        validator = new LectureValidator();
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
        boolean res = validator.isNameValid("ASE");
        Assert.assertTrue(res);
    }

    @Test
    public void isNameValid_someLowercaseName_isValid(){
        boolean res = validator.isNameValid("ase");
        Assert.assertTrue(res);
    }

    @Test
    public void isNameValid_concatenatedNames_isValid(){
        boolean res = validator.isNameValid("Advanced Software Engineering");
        Assert.assertTrue(res);
    }

    @Test
    public void isNumberValid_null_isInvalid(){
        boolean res = validator.isNumberValid(null);
        Assert.assertFalse(res);
    }

    @Test
    public void isNumberValid_emptyString_isInvalid(){
        boolean res = validator.isNumberValid("");
        Assert.assertFalse(res);
    }

    @Test
    public void isNumberValid_someString_isInvalid(){
        boolean res = validator.isNumberValid("test");
        Assert.assertFalse(res);
    }

    @Test
    public void isNumberValid_singleNumberWithDot_isInvalid(){
        boolean res = validator.isNumberValid("123.");
        Assert.assertFalse(res);
    }

    @Test
    public void isNumberValid_twoDigitsWithDot_isInvalid(){
        boolean res = validator.isNumberValid("1.2");
        Assert.assertFalse(res);
    }

    @Test
    public void isNumberValid_onlyOneNumberWithCorrectLength_isInvalid(){
        boolean res = validator.isNumberValid("123.1");
        Assert.assertFalse(res);
    }

    @Test
    public void isNumberValid_twoStringsWithCorrectLengths1_isInvalid(){
        boolean res = validator.isNumberValid("123.abc");
        Assert.assertFalse(res);
    }

    @Test
    public void isNumberValid_twoStringsWithCorrectLengths2_isInvalid(){
        boolean res = validator.isNumberValid("abc.123");
        Assert.assertFalse(res);
    }

    @Test
    public void isNumberValid_twoNumbersWithCorrectLengths1_isValid(){
        boolean res = validator.isNumberValid("123.123");
        Assert.assertTrue(res);
    }

    @Test
    public void isNumberValid_twoNumbersWithCorrectLengths2_isValid(){
        boolean res = validator.isNumberValid("123.000");
        Assert.assertTrue(res);
    }

    @Test
    public void isNumberValid_twoNumbersTooLong_isInvalid(){
        boolean res = validator.isNumberValid("123.1234");
        Assert.assertFalse(res);
    }

    @Test
    public void isLecturerIdValid_null_isInvalid(){
        boolean res = validator.isLecturerIdValid(null);
        Assert.assertFalse(res);
    }

    @Test
    public void isLecturerIdValid_negativeNum_isInvalid(){
        // is -1 better than -10 ?
        boolean res = validator.isLecturerIdValid(-10L);
        Assert.assertFalse(res);
    }

    @Test
    public void isLecturerIdValid_zero_isInvalid(){
        boolean res = validator.isLecturerIdValid(0L);
        Assert.assertFalse(res);
    }

    @Test
    public void isLecturerIdValid_positiveNum_isValid(){
        // is 1 better than 27 ?
        boolean res = validator.isLecturerIdValid(27L);
        Assert.assertTrue(res);
    }

    @Test
    public void isLectureValid_null_isInvalid(){
        boolean res = validator.isLectureValid(null);
        Assert.assertFalse(res);
    }

    @Test
    public void isLectureValid_someLecture_isValid(){
        Lecture someLecture = new Lecture(0L, "ase", "123.456", 1L);
        boolean res = validator.isLectureValid(someLecture);
        Assert.assertTrue(res);
    }
}
