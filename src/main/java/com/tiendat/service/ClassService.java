package com.tiendat.service;

import com.tiendat.dto.ClassDto;

import java.util.List;

public interface ClassService {
    List<ClassDto> findGoodStudent();
    List<ClassDto> countStudentPerClass();
}
