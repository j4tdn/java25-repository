package com.tiendat.dao;

import com.tiendat.dto.StudentDto;
import com.tiendat.dto.StudentMaxAvgDto;
import com.tiendat.persistence.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findStudentByClassId(Long classId);
    List<StudentDto> findStudentHasAvgScore();
    List<StudentMaxAvgDto> findStudentMaxAvgPerClass();
}
