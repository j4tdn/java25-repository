package com.tiendat.dto;

public class StudentMaxAvgDto {
    private Long classId;
    private String className;
    private Long studentId;
    private String studentName;
    private Double avgScore;

    public StudentMaxAvgDto(Long classId, String className, Long studentId, String studentName, Double avgScore) {
        this.classId = classId;
        this.className = className;
        this.studentId = studentId;
        this.studentName = studentName;
        this.avgScore = avgScore;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Double avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public String toString() {
        return "StudentMaxAvgDto{" +
                "classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", avgScore=" + avgScore +
                '}';
    }
}
