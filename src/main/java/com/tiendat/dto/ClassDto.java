package com.tiendat.dto;

public class ClassDto {
    private String className;
    private int quantityStudent;

    public ClassDto() {
    }

    public ClassDto(String className, int quantityStudent) {
        this.className = className;
        this.quantityStudent = quantityStudent;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getQuantityStudent() {
        return quantityStudent;
    }

    public void setQuantityStudent(int quantityStudent) {
        this.quantityStudent = quantityStudent;
    }

    @Override
    public String toString() {
        return "ClassDto{" +
                "className='" + className + '\'' +
                ", quantityStudent=" + quantityStudent +
                '}';
    }
}
