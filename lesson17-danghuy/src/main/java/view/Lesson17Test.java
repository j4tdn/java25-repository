package view;

import java.util.List;
import java.util.Scanner;

import persistence.Student;
import service.StudentService;
import service.StudentServiceImpl;

public class Lesson17Test {

	/*
		• List all student by class id
		• List the class name and number (count) of students, name of students who have Math point >= 8
		and Literature >= 8
		• Count/statistic number of students per class
		• Find students who have average of points >= 8.2
		• Find/statistic students who have max average of point in their class
	 */
	
	public static void main(String[] args) {
		
		StudentService studentService = new StudentServiceImpl();
		
		// List all student by class id
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter class ID: ");
		
		int classId = sc.nextInt();
		
		List<Student> students = studentService.findByClassId(classId);
		
		if(students.isEmpty()) {
			System.out.println("No students");
		} else {
			for(Student student: students) {
				System.out.println(student);
			}
		}
		
		studentService.findGoodStudent();
		
		sc.close();
		
	}
	
}
