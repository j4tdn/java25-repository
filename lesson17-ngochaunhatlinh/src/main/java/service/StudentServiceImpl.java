package service;

import dao.JdbcStudentDao;
import dao.StudentDao;
import dto.ClassMaxAvgStudentDto;
import dto.ClassStudentCountDto;
import dto.GoodStudentByClassDto;
import dto.StudentAvgDto;
import persistence.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao;

    public StudentServiceImpl() {
        studentDao = new JdbcStudentDao();
    }

    @Override
    public List<Student> getStudentsByClassId(int classId) {
        return studentDao.getStudentsByClassId(classId);
    }

    @Override
    public List<GoodStudentByClassDto> getGoodMathAndLiteratureStudentsByClass() {
        return studentDao.getGoodMathAndLiteratureStudentsByClass();
    }

    @Override
    public List<ClassStudentCountDto> countStudentsPerClass() {
        return studentDao.countStudentsPerClass();
    }

    @Override
    public List<StudentAvgDto> getStudentsWithAvgScoreGte(double minAvgScore) {
        return studentDao.getStudentsWithAvgScoreGte(minAvgScore);
    }

    @Override
    public List<ClassMaxAvgStudentDto> getMaxAvgScoreStudentsPerClass() {
        return studentDao.getMaxAvgScoreStudentsPerClass();
    }
}
