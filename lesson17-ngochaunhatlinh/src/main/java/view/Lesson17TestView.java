package view;

import service.StudentService;
import service.StudentServiceImpl;

import static utils.PrintUtils.generate;

public class Lesson17TestView {

    private static final StudentService studentService = new StudentServiceImpl();

    public static void main(String[] args) {
        generate(
                "1. List all student by class id (cid = 2)",
                studentService.getStudentsByClassId(2)
        );

        generate(
                "2. List the class name and number of students, name of students who have Math point >= 8 and Literature >= 8",
                studentService.getGoodMathAndLiteratureStudentsByClass()
        );

        generate(
                "3. Count/statistic number of students per class",
                studentService.countStudentsPerClass()
        );

        generate(
                "4. Find students who have average of points >= 8.2",
                studentService.getStudentsWithAvgScoreGte(8.2)
        );

        generate(
                "5. Find/statistic students who have max average of point in their class",
                studentService.getMaxAvgScoreStudentsPerClass()
        );
    }
}
