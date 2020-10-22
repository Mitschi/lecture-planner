package com.github.mitschi.services.graphql;

import com.github.mitschi.models.Lecture;

/**
 * This class is used as DTO for GraphQL.
 */
class LectureInput {
    private String name;
    private String number;
    private Long lecturerId;

    public LectureInput() {
    }

    public LectureInput(String name, String number, Long lecturerId) {
        this.name = name;
        this.number = number;
        this.lecturerId = lecturerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getLecturerId() {
        return lecturerId;
    }

    public void setLecturerId(Long lecturerId) {
        this.lecturerId = lecturerId;
    }

    public static LectureInput fromLecture(Lecture l){
        return new LectureInput(l.getName(), l.getNumber(), l.getLecturerId());
    }
}
