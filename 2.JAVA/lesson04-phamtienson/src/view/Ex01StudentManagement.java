package view;

import java.util.Scanner;

import bean.Student;

public class Ex01StudentManagement {
	public static void inputStudent(Student student, Scanner scanner) {
        System.out.println("Enter student information:");
        
        System.out.print("Student ID: ");
        student.setStudentId(scanner.nextInt());
        scanner.nextLine(); 
        
        System.out.print("Full Name: ");
        student.setFullName(scanner.nextLine());
        
        System.out.print("Theory Score: ");
        student.setTheoryScore(scanner.nextDouble());
        
        System.out.print("Practice Score: ");
        student.setPracticeScore(scanner.nextDouble());
    }
    
    public static void findHighAverageScoreStudents(Student[] students) {
        System.out.println("\nStudents with average score > 8.5:");
        for (Student student : students) {
            Double avgScore = student.Average();
            if (avgScore != null && avgScore > 8.5) {
                System.out.println(student);
            }
        }
    }
    
    public static void findTheoryHigherThanPractice(Student[] students) {
        System.out.println("\nStudents with theory score higher than practice score:");
        for (Student student : students) {
            if (student.getTheoryScore() != null && student.getPracticeScore() != null &&
                student.getTheoryScore() > student.getPracticeScore()) {
                System.out.println(student);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Student sv1 = new Student(001, "Nguyễn Hồ Thùy Dương", 8.5, 9.0);
        Student sv2 = new Student(002, "Nguyễn Thu Hà", 9.0, 8.5);
        Student sv3 = new Student();
        
        inputStudent(sv3, scanner);
        
        Student[] students = {sv1, sv2, sv3};
        
        System.out.println("\nAll students:");
        for (Student student : students) {
            System.out.println(student);
        }
        
        findHighAverageScoreStudents(students);
        
        findTheoryHigherThanPractice(students);
        
        scanner.close();
    }

}