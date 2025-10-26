package ex01;

import java.util.Scanner;

public class StudentManager {

    public static void highScoreStudent(Student[] students) {
        System.out.println("\n=== Sinh vien co diem trung binh > 8.5 ===");
        boolean found = false;

        for (Student s : students) {
            if (s != null && s.getAverage() > 8.5) {
                System.out.println(s);
                System.out.println("-------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong co sinh vien nao co diem trung binh > 8.5.");
        }
    }

    public static void theoryScoreHigher(Student[] students) {
        System.out.println("\n=== Sinh vien co diem ly thuyet > diem thuc hanh ===");
        boolean found = false;

        for (Student s : students) {
            if (s != null && s.getTheoryScore() != null && s.getPracticeScore() != null) {
                if (s.getTheoryScore() > s.getPracticeScore()) {
                    System.out.println(s);
                    System.out.println("-------------------");
                    found = true;
                }
            }
        }
        if (!found) {
            System.out.println("Khong co sinh vien nao co diem ly thuyet lon hon diem thuc hanh.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student sv1 = new Student(1, "Tran Minh Quan", 9.0, 8.5);
        Student sv2 = new Student(2, "Tran Vu Quoc Vuong", 7.0, 7.5);

        Student sv3 = new Student(null, null, null, null);

        System.out.println("=== Nhap thong tin cho sinh vien thu 3 ===");

        System.out.print("Nhap ma sinh vien: ");
        sv3.setStudentId(Integer.parseInt(sc.nextLine()));

        System.out.print("Nhap ho ten: ");
        sv3.setFullName(sc.nextLine());

        System.out.print("Nhap diem ly thuyet: ");
        sv3.setTheoryScore(Double.parseDouble(sc.nextLine()));

        System.out.print("Nhap diem thuc hanh: ");
        sv3.setPracticeScore(Double.parseDouble(sc.nextLine()));

        Student[] students = new Student[] { sv1, sv2, sv3 };

        System.out.println("\n=== Danh sach sinh vien ===");
        for (Student s : students) {
            System.out.println(s);
            System.out.println("-------------------");
        }

        highScoreStudent(students);
        theoryScoreHigher(students);

        sc.close();
    }
}
