package exercises;

import java.util.Scanner;

import bean.Student;
import utils.PointStudent;

public class Ex01StudentManagerment {
	
	static Scanner ip = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Student s1 = new Student("1", "Huy", 10d, 9d);
		Student s2 = new Student("2", "Hoang", 4d, 5d);
		Student s3 = new Student();
		
		System.out.println("Nhap ID:");
		String ipId = ip.nextLine();
		s3.setId(ipId);
		
		System.out.println("Nhap ten:");
		String ipName = ip.nextLine();
		s3.setName(ipName);
		
		System.out.println("Nhap diem ly thuyet:");
		Double ipTheoreticalPoint = ip.nextDouble();
		s3.setTheoreticalPoint(ipTheoreticalPoint);
		
		System.out.println("Nhap diem thuc hanh:");
		Double ipPracticalPoint = ip.nextDouble();
		s3.setPracticalPoint(ipPracticalPoint);
		
		Student[] students = new Student[3];
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		
		for(Student student: students){
			PointStudent.calcPoint(student);
			PointStudent.theoreticalPointGreaterThanpracticalPoint(student);
		}
		
		ip.close();
	}
}