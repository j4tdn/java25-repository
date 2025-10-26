package homework1;

import java.util.Scanner;

public class StudentManagerment extends Student {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Student sv1 = new Student(1, "huynhnguyendoan", 8.5,8.0);
		Student sv2 = new Student(2, "bestfriend",8.8,8.5);
		
		Student sv3 = new Student();
		System.out.println("Nhap ID cho sv3: ");
		sv3.setStudentID(sc.nextInt());
		sc.nextLine();
		System.out.println("Nhap ho ten cho sv3: ");
		sv3.setFullName(sc.nextLine());
		System.out.println("Nhap diem du kien cua sv3: ");
		sv3.setTheoryScore(sc.nextDouble());
		System.out.println("Nhap diem thuc te cua sv3: ");
		sv3.setPracticeScore(sc.nextDouble());
		
		Student[] students = {sv1,sv2,sv3};
		
		System.out.println("\nHoc sinh co diem trung binh > 8.5: ");
		findStudentWithHighAverage(students);
		
		System.out.println("\nHoc sinh co diem du kien cao hon diem thuc te: ");
		findStudentTheoryHigher(students);
		
		
		
		
		
	}
}
