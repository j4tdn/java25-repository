package com.tiendat.service;

import com.tiendat.dao.ClassDao;
import com.tiendat.dao.JdbcClassDao;
import com.tiendat.dto.ClassDto;

import java.util.List;

public class ClassServiceImpl implements ClassService{
    private final ClassDao classDao;

    public ClassServiceImpl() {
        classDao = new JdbcClassDao();
    }


    @Override
    public List<ClassDto> findGoodStudent() {
        return classDao.getClassHasStudentGoodMathAndLiterature();
    }

    @Override
    public List<ClassDto> countStudentPerClass() {
        return classDao.countStudentPerClass();
    }
}
