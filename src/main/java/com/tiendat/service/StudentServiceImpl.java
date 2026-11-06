package com.tiendat.service;

import com.tiendat.dao.JdbcStudentDao;
import com.tiendat.dao.StudentDao;
import com.tiendat.dto.StudentDto;
import com.tiendat.dto.StudentMaxAvgDto;
import com.tiendat.persistence.Student;

import java.util.List;
import java.util.Objects;

public class StudentServiceImpl implements StudentService{
    private final StudentDao studentDao;

    public StudentServiceImpl() {
        studentDao = new JdbcStudentDao();
    }

    @Override
    public List<Student> findStudentByClassId(Long classId) {
        Objects.requireNonNull(classId, "ClassId is required");
        return studentDao.findStudentByClassId(classId);
    }

    @Override
    public List<StudentDto> findStudentHasAvgScore() {
        return studentDao.findStudentHasAvgScore();
    }

    @Override
    public List<StudentMaxAvgDto> findStudentHasMaxAvg() {
        return studentDao.findStudentMaxAvgPerClass();
    }
}
