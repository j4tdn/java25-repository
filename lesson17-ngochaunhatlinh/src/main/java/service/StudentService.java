package service;

import dto.ClassMaxAvgStudentDto;
import dto.ClassStudentCountDto;
import dto.GoodStudentByClassDto;
import dto.StudentAvgDto;
import persistence.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudentsByClassId(int classId);

    List<GoodStudentByClassDto> getGoodMathAndLiteratureStudentsByClass();

    List<ClassStudentCountDto> countStudentsPerClass();

    List<StudentAvgDto> getStudentsWithAvgScoreGte(double minAvgScore);

    List<ClassMaxAvgStudentDto> getMaxAvgScoreStudentsPerClass();
}
