package dao;

import dto.ClassMaxAvgStudentDto;
import dto.ClassStudentCountDto;
import dto.GoodStudentByClassDto;
import dto.StudentAvgDto;
import persistence.Student;

import java.util.List;

public interface StudentDao {

    // 1. List all student by class id
    List<Student> getStudentsByClassId(int classId);

    // 2. List the class name and number of students, name of students who have Math point >= 8 and Literature >= 8
    List<GoodStudentByClassDto> getGoodMathAndLiteratureStudentsByClass();

    // 3. Count/statistic number of students per class
    List<ClassStudentCountDto> countStudentsPerClass();

    // 4. Find students who have average of points >= 8.2
    List<StudentAvgDto> getStudentsWithAvgScoreGte(double minAvgScore);

    // 5. Find/statistic students who have max average of point in their class
    List<ClassMaxAvgStudentDto> getMaxAvgScoreStudentsPerClass();
}
