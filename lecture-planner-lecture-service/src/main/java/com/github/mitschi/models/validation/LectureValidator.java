package com.github.mitschi.models.validation;

import com.github.mitschi.models.Lecture;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class LectureValidator {

    public boolean isLectureValid(Lecture l) {
        return l != null
                && isNameValid(l.getName())
                && isNumberValid(l.getNumber())
                && isLecturerIdValid(l.getLecturerId());
    }

    public boolean isNameValid(String name) {
        return name != null && !name.isEmpty();
    }

    public boolean isNumberValid(String number) {
        if (number == null)
            return false;

        String[] numberParts = number.split("\\.");

        if (numberParts.length != 2)
            return false;

        return Arrays.stream(numberParts).allMatch(this::isNumberPartValid);
    }

    private boolean isNumberPartValid(String numberPart) {
        if (numberPart.length() != 3)
            return false;

        try {
            int numberPartAsInt = Integer.parseInt(numberPart);
            return numberPartAsInt >= 0;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public boolean isLecturerIdValid(Long lecturerId) {
        // as the employee is in another microservice, we wont check the actual foreign key constraint here
        return lecturerId != null && lecturerId > 0;
    }
}
