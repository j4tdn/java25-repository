package com.tiendat.service;

import com.tiendat.dto.StudentDto;
import com.tiendat.dto.StudentMaxAvgDto;
import com.tiendat.persistence.Student;

import java.util.List;

public interface StudentService {
    List<Student> findStudentByClassId(Long classId);
    List<StudentDto> findStudentHasAvgScore();
    List<StudentMaxAvgDto> findStudentHasMaxAvg();
}
