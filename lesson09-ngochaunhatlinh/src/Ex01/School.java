package Ex01;

public class School {
	public static void main(String[] args) {
		Student[]  students = {
				new Student(102, "Nam", 'C'),
				new Student(103, "Bảo", 'F'),
				new Student(104, "Hoàng", 'D'),
				new Student(105, "Nguyên", 'B'),
				new Student(107, "Vũ", 'F'),
				new Student(109, "Lan", 'A'),
				new Student(202, "Đạt", 'C'),
				new Student(103, "Bảo", 'A'),
				new Student(107, "Linh", 'A'),
				new Student(104, "Hoàng", 'B')
		};
		System.out.println("Danh sach sv dat loai A");
		for(Student s : getStudentA(students)) {
			System.out.println(s);
		}
	}
	
	public static Student[] getStudentA(Student[] students) {
		int count =0;
		for(Student s : students) {
			if(s.ranking == 'A') {
				count++;
			}
		}
		Student[] kq = new Student[count];
		int output =0;
		for(Student s : students) {
			if(s.ranking == 'A') {
				kq[output++] =s;
			}
		}
		
		return kq;
		
		
	}
}
