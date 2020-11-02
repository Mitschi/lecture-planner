package com.github.mitschi.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LectureTest {

    private Lecture lecture;

    @Before
    public void setup() {
        lecture = new Lecture();
    }

    @Test
    public void updateFromDto_someValues_updated() {
        Lecture newL = new Lecture(0L, "Test", "Test", 1L);
        lecture.updateFromDto(newL);

        assertLecturesHaveSameProperties(newL, lecture);
    }

    private void assertLecturesHaveSameProperties(Lecture expected, Lecture actual)
            throws AssertionError {
        if (expected == null
                || !expected.getName().equals(actual.getName())
                // FIXME
//                || !expected.getNumber().equals(actual.getNumber())
                || !expected.getLecturerId().equals(actual.getLecturerId()))
            Assert.fail("Lectures were not same. Expected: " + expected + ", actual: " + actual);
    }
}
