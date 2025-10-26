import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        Student sv1 = new Student(1, "Huynh Viet Thinh1", 8.5, 9.0);

       
        Student sv2 = new Student(2, "Pham Van Tuan ", 9.0, 8.5);


        Student sv3 = new Student();
        
        System.out.println("Nhap thong tin cho sv3:");
        System.out.print("Ma sinh vien: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Ho ten: ");
        String name = scanner.nextLine();
        
        System.out.print("Diem ly thuyet: ");
        double theory = scanner.nextDouble();
        
        System.out.print("Diem thuc hanh: ");
        double practice = scanner.nextDouble();
        
      
        sv3.setStudentId(id);
        sv3.setFullName(name);
        sv3.setTheoryScore(theory);
        sv3.setPracticeScore(practice);

       
        Student[] students = {sv1, sv2, sv3};

        
        System.out.println("\n=== Danh sach sinh vien ===");
        for (Student student : students) {
            System.out.println(student);
        }

        
        System.out.println("\n=== Danh sach sinh vien co diem trung binh > 8.5 ===");
        List<Student> highAverageStudents = findStudentsWithHighAverage(students, 8.5);
        if (highAverageStudents.isEmpty()) {
            System.out.println("Khong co sinh vien nao co diem trung binh > 8.5");
        } else {
            for (Student student : highAverageStudents) {
                System.out.println(student);
            }
        }

       
        System.out.println("\n=== Danh sach sinh vien co diem ly thuyet > diem thuc hanh ===");
        List<Student> theoryHigherStudents = findStudentsWithHigherTheory(students);
        if (theoryHigherStudents.isEmpty()) {
            System.out.println("Khong co sinh vien nao co diem ly thuyet > diem thuc hanh");
        } else {
            for (Student student : theoryHigherStudents) {
                System.out.println(student);
            }
        }

        scanner.close();
    }

   

    public static List<Student> findStudentsWithHighAverage(Student[] students, double threshold) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            Double average = student.calculateAverageScore();
            if (average != null && average > threshold) {
                result.add(student);
            }
        }
        return result;
    }

    public static List<Student> findStudentsWithHigherTheory(Student[] students) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getTheoryScore() != null && student.getPracticeScore() != null) {
                if (student.getTheoryScore() > student.getPracticeScore()) {
                    result.add(student);
                }
            }
        }
        return result;
    }
}


