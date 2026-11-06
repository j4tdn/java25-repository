package com.tiendat.persistence;

import com.tiendat.common.Gender;

import java.util.Objects;

public class Student {
    private Long id;
    private String name;
    private Gender gender;
    private Long classId;

    public Student() {
    }

    public Student(Long id, String name, Gender gender, Long classId) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.classId = classId;
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

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Student student)) return false;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", classId=" + classId +
                '}';
    }
}
