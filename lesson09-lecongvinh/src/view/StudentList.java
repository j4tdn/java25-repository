package view;

import java.util.ArrayList;
import java.util.Arrays;

import bean.Student;

public class StudentList {

	public static void main(String[] args) {
		Student[] students = {
				new Student(102, "Nam", 'C'),
				new Student(103, "Bảo", 'F'),
				new Student(104, "Hoàng", 'D'),
				new Student(105, "Nguyên",'B'),
				new Student(107, "Vũ", 'F'),
				new Student(109, "Lan",'A'),
				new Student(202, "Đạt", 'C'),
				new Student(103, "Bảo",'F'),
				new Student(107, "Vũ", 'C'),
				new Student(104, "Hoàng", 'B')
		};
		ArrayList<Student> aStudents = new ArrayList<>();
		ArrayList<Student> fStudents = new ArrayList<>();
		
		System.out.println("List of student has A mark: ");
		for(Student student : students) {
			if(student.getMark() == 'A') {
				System.out.println(student.toString());
				aStudents.add(student);
				
			}
		}
		System.out.println("----------------------------");
		System.out.println("List of student has F mark: ");
		for(Student student : students) {
			if(student.getMark() == 'F') {
				System.out.println(student.toString());
				fStudents.add(student);
			}
		}
	}
}