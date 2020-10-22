package com.github.mitschi.models;

public class Lecture {
    private Long id;

    private String name;

    private String number;

    private Long lecturerId;

    private Employee lecturer;

    public Lecture(){
    }

    public Lecture(String name, String number, Long lecturerId) {
        this.name = name;
        this.number = number;
        this.lecturerId = lecturerId;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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

    public Employee getLecturer() {
        return lecturer;
    }

    public void setLecturer(Employee lecturer) {
        this.lecturer = lecturer;
    }

    public void updateFromDto(Lecture other) {
        this.setName(other.getName());
        this.setNumber(other.getNumber());
        this.setLecturerId(other.getLecturerId());
        this.setLecturer(other.getLecturer());
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", lecturerId='" + lecturerId + '\'' +
                '}';
    }
}
