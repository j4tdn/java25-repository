package ex01;

import java.util.Locale;
import java.util.Scanner;

public class StudentManagement {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        Student sv1 = new Student(1, "Truc Phuong", 9.0, 8.5);
        Student sv2 = new Student(2, "Anh Khoa ", 8.0, 7.5);
        Student sv3 = new Student();
        System.out.println("Enter information for sv3:");
        System.out.print("Student ID: ");
        sv3.setStudentId(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Full Name: ");
        sv3.setFullName(scanner.nextLine());
        System.out.print("Theory Score: ");
        sv3.setTheoryScore(scanner.nextDouble());
        System.out.print("Practice Score: ");
        sv3.setPracticeScore(scanner.nextDouble());

        Student[] students = {sv1, sv2, sv3};

        System.out.println("\n=== Student List ===");
        for (Student s : students) {
            System.out.println(s);
        }

        // 4. Students tb trên 8.5
        System.out.println("\n=== Students with average score > 8.5 ===");
        for (Student s : students) {
            if (s.getAverageScore() > 8.5) {
                System.out.println(s);
            }
        }

        // 5. Students điểm lí thuyết lớn hơn thực hanhff
        System.out.println("\n=== Students with theory score > practice score ===");
        for (Student s : students) {
            if (s.getTheoryScore() > s.getPracticeScore()) {
                System.out.println(s);
            }
        }

        scanner.close();
    }
}
