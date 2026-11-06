package com.tiendat.dao;

import com.tiendat.dto.ClassDto;

import java.util.List;

public interface ClassDao {
    List<ClassDto> getClassHasStudentGoodMathAndLiterature();
    List<ClassDto> countStudentPerClass();
}
