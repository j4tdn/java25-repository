package utils;

import bean.Student;

public class PointStudent {
	private PointStudent() {
	}
	
	public static void calcPoint(Student student) {
		Double point = (student.getTheoreticalPoint() + student.getPracticalPoint()) / 2;
		if(point > 8.5) {
			System.out.printf("\nSinh vien ID: %s, ten: %s co diem trung binh lon hon 8.5\n", student.getId(), student.getName());
		}
	}
	
	public static void theoreticalPointGreaterThanpracticalPoint(Student student) {
		if(student.getTheoreticalPoint() > student.getPracticalPoint()) {
			System.out.printf("\nSinh vien ID: %s, ten: %s co diem ly thuyet lon hon diem thuc hanh\n", student.getId(), student.getName());
		}
	}
}
