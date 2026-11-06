package com.tiendat.dto;

import com.tiendat.common.Gender;

public class StudentDto {
    private Long studentId;
    private String studentName;
    private Gender gender;
    private Double score;

    public StudentDto(Long studentId, String studentName, Gender gender, Double score) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.score = score;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", score=" + score +
                '}';
    }
}
