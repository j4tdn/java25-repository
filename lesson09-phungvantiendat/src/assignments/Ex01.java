package assignments;

import bean.Ranking;
import bean.Student;

public class Ex01 {
	public static void main(String[] args) {
		Student[] students = getStudents();
		printStudentHasRankA(students);
		printStudentHasStudiedDSAMoreThanOneTime(students);
	}
	
	public static Student[] getStudents() {
		Student[] students = {
				new Student(102, "Nam", Ranking.C),
				new Student(103, "Bảo", Ranking.F),
				new Student(104, "Hoàng", Ranking.D),
				new Student(105, "Nguyên", Ranking.B),
				new Student(107, "Vũ", Ranking.F),
				new Student(109, "Lan", Ranking.A),
				new Student(202, "Đạt", Ranking.C),
				new Student(103, "Bảo", Ranking.F),
				new Student(107, "Vũ", Ranking.C),
				new Student(104, "Hoàng", Ranking.B)
		};
		return students;
	}
	
	public static void printStudentHasRankA(Student[] students) {
		for(int i = 0;i<students.length;++i) {
			if(students[i].getRank() == Ranking.A) {
				System.out.println(students[i]);
			}
		}
	}
	
	public static void printStudentHasStudiedDSAMoreThanOneTime(Student[] students) {
		int []res = new int[10000000];
		
		
		for(int i = 0;i<students.length;++i) {
			if(students[i].getRank() == Ranking.F) {
				res[students[i].getId()]++;
			}
		}
		
		for(int i = 0;i<res.length;++i) {
			if(res[i] > 1) {
				for(int j = 0;j<students.length;++j) {
					if(students[j].getId() == i) {
						System.out.println(students[j]);
					}
				}
			}
		
		}
	}
	
//	public static boolean isExist(Tuple[] tuples, int id) {
//		for(int i = 0;i<tuples.length;++i) {
//			if(tuples[i].getId() == id) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	static class Tuple{
//		private int id;
//		private int cnt;
//		
//		public Tuple(int  id, int cnt) {
//			this.id = id;
//			this.cnt = cnt;
//		}
//
//		
//		
//		public int getId() {
//			return id;
//		}
//
//
//
//		public void setId(int id) {
//			this.id = id;
//		}
//
//
//
//		public int getCnt() {
//			return cnt;
//		}
//		public void setCnt(int cnt) {
//			this.cnt = cnt;
//		}
//		
//		
//	}
}

