package Bai1;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Student s1 = new Student(1, "Nguyễn Minh Duy", 8, 6);
		
		Student s2 = new Student(2, "Nguyễn Tuấn Tú", 9, 10);
		
		Student s3 = new Student();
		
		System.out.println("Nhập ID: ");
		s3.setStudentId(sc.nextInt());
		sc.nextLine();
		System.out.println("Nhập tên sinh viên: ");
		s3.setName(sc.nextLine());
		System.out.println("Nhập điểm lý thuyết: ");
		s3.setTheoryScore(sc.nextDouble());
		System.out.println("Nhập điểm thực hành: ");
		s3.setPracticeScore(sc.nextDouble());
		
		Student[] students = {s1, s2, s3};
		
		System.out.println("Sinh viên có điểm trung bình lớn hơn 8.5 là: ");
		for(Student s : students) {
			if(s.getAverageScore() > 8.5) {
				System.out.println(s);
			}
		}
		
		System.out.println("\nSinh viên có điểm lý thuyết lớn hơn Thực hành là: ");
		for(Student s : students) {
			if(s.getTheoryScore() > s.getPracticeScore()) {
				System.out.println(s);
			}
		}
	}

}
