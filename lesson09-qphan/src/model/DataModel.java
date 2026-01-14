package model;

import static common.Rank.A;
import static common.Rank.B;
import static common.Rank.C;
import static common.Rank.D;
import static common.Rank.F;

import bean.Student;

public class DataModel {
	
	private DataModel() {
	}
	
	public static Student[] mockStudents() {
		return new Student[] {
			new Student(102, "Nam", A),
			new Student(103, "Bảo", F),
			new Student(104, "Hoàng", D),
			new Student(105, "Nguyên", B),
			new Student(107, "Vũ", F),
			new Student(109, "Lan", A),
			new Student(202, "Đạt", C),
			new Student(103, "Bảo", F),
			new Student(107, "Vũ", C),
			new Student(104, "Hoàng", B)
		};
	}
}
