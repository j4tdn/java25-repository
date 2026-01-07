package view;

import java.util.Arrays;
import bean.Rank;
import bean.Student;

public class Ex01ManageStudents {

	public static void main(String[] args) {
		
		Student[] students = {
				new Student(102, "Nam", Rank.C),
				new Student(103, "Bảo", Rank.F),
				new Student(104, "Hoàng", Rank.D),
				new Student(105, "Nguyên", Rank.B),
				new Student(107, "Vũ", Rank.F),
				new Student(109, "Lan", Rank.A),
				new Student(202, "Đạt", Rank.C),
				new Student(103, "Bảo", Rank.F),
				new Student(107, "Vũ", Rank.C),
				new Student(104, "Hoàng", Rank.B)
		};
		
		System.out.println("Danh sách sinh viên từng đạt loại A trong năm 2024 --> "
				+ Arrays.toString(getStudentsByRank(students, Rank.A)));
		System.out.println("Danh sách sinh viên đã tham gia học lại(học nhiều hơn 1 lần)môn cấu trúc dữ liệu trong\r\n"
				+ "năm 2024 --> "
				+ Arrays.toString(getLearnAgainStudents(students)));
		
	}
	
	private static Student[] getStudentsByRank(Student[] students, Rank rank) {
		int count = 0;
		for(Student student : students) {
			if(student.getRank() == rank) {
				count++;
			}
		}
		Student[] result = new Student[count];
		int index = 0;
		for(Student student : students) {
			if(student.getRank() == rank) {
				result[index] = student;
			}
		}
		
		return result;
	}
	
	private static Student[] getLearnAgainStudents(Student[] students) {
		long[] ids = new long[students.length];
		int idIndex = 0;
		for(Student student : students) {
			long studentId = student.getId();
			ids[idIndex] = studentId;
			idIndex++;
		}
		int[] countIds = new int[1000];
		for(long id : ids) {
			countIds[(int) id]++;
		}
		
		int count = 0;
		for(Student student : students) {
			if(countIds[student.getId()] >= 2) {
				System.out.println(student.getId() + " --> " + countIds[student.getId()]);
				count++;
			}
		}
		Student[] result = new Student[count];
		int resultIndex = 0;
		for(Student student : students) {
			if(countIds[student.getId()] >= 2) {
				result[resultIndex] = student;
				resultIndex++;
			}
		}
		return result;
	}
	
}
