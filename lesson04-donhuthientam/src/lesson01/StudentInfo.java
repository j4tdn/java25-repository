package lesson01;

import java.util.Scanner;

public class StudentInfo {
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {

		StudentManagement sv1 = new StudentManagement(101, "A", 9, 8);
		StudentManagement sv2 = new StudentManagement(201, "B", 10, 8);

		StudentManagement[] list = { sv1, sv2, Info(ip) };

		for (StudentManagement sv : list) {
			if (Average(sv) || Score(sv)) {
				System.out.println(sv);
			}
		}

	}

	private static boolean Average(StudentManagement sv) {
		if (sv.avg() >= 8.5d) {
			return true;
		}
		return false;
	}

	private static boolean Score(StudentManagement sv) {
		if (sv.getTheoretical() > sv.getPractice()) {
			return true;
		}
		return false;
	}

	private static StudentManagement Info(Scanner ip) {
		System.out.println("NHAP MA SINH VIEN: ");
		int num = Integer.parseInt(ip.nextLine());

		System.out.println("NHAP TEN");
		String name = ip.nextLine();

		System.out.println("NHAP DIEM LY THUYET");
		double lt = Double.parseDouble(ip.nextLine());

		System.out.println("NHAP DIEM THUC HANH");
		double th = Double.parseDouble(ip.nextLine());

		return new StudentManagement(num, name, lt, th);

	}

}
