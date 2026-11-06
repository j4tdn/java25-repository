package com.tiendat;

import com.tiendat.service.ClassService;
import com.tiendat.service.ClassServiceImpl;
import com.tiendat.service.StudentService;
import com.tiendat.service.StudentServiceImpl;
import static com.tiendat.utils.PrintUtils.*;

/**
 * Hello world!
 */
public class App {
    private static StudentService studentService;
    private static ClassService classService;

    static {
        studentService = new StudentServiceImpl();
        classService = new ClassServiceImpl();
    }

    public static void main(String[] args) {
//        generate("1. List all student By Class id",
//                studentService.findStudentByClassId(2L));

//        generate("2. List the class name and number of students, name of students who have Math point >= 8\n" +
//                "and Literature >= 8",
//                classService.findGoodStudent());

//        generate("3. count student per class",
//                classService.countStudentPerClass());

//        generate("4. Find students who have average of points >= 8.2",
//                studentService.findStudentHasAvgScore());

        generate("5. Find/statistic students who have max average of point in their class",
                studentService.findStudentHasMaxAvg());
    }
}
