package view;

public class Ex01 {
	
	static class Student {
		int id;
		String name;
		char rank;
		public Student(int id, String name, char rank) {
			super();
			this.id = id;
			this.name = name;
			this.rank = rank;
		}
	}
	
	public static Student[] getStudents() {
		Student[] students = {
				new Student(102, "Nam", 'C'),
				new Student(103, "Bảo", 'F'),
				new Student(104, "Hoàng", 'D'),
				new Student(105, "Nguyên", 'B'),
				new Student(107, "Vũ", 'F'),
				new Student(109, "Lan", 'A'),
				new Student(202, "Đạt", 'C'),
				new Student(103, "Bảo", 'F'),
				new Student(107, "Vũ", 'C'),
				new Student(104, "Hoàng", 'B')
		};
		return students;
	}
	public static Student[] getStudentsTypeA(Student[] students) {
		int count = 0;
		for(int i = 0; i < students.length; i++) {
			if(students[i].rank == 'A') {
				count++;
			}
		}
		Student[] result = new Student[count];
		int dx = 0;
		for(int i = 0; i < students.length; i++) {
			if(students[i].rank == 'A') {
				result[dx] = students[i];
				dx++;
			}
		}
		return result;
	}
	public static Student[] getsStudentsRetake(Student[] students) {
		int n = students.length;
		
		int countR = 0;
		for(int i = 0; i < n; i++) {
			int ap = 0;
			for( int j = 0; j < n; j++) {
				if(students[i].id == students[j].id) {
					ap++;
				}
			}
			if(ap > 1) {
				boolean firstTime = true;
				for(int k = 0; k < i; k++) {
					if(students[k].id == students[i].id) {
						firstTime = false;
						break;
					}
				}
				if(firstTime) countR++;
			}
		}
		
		Student[] result = new Student[countR];
		
		int dx = 0;
		for(int i = 0; i < n; i++) {
			int ap = 0;
			for(int j = 0; j < n; j++) {
				if(students[i].id == students[j].id) {
					ap++;
				}
			}
			if(ap > 1) {
				boolean firstTime = true;
				for(int k = 0; k < i; k++) {
					if(students[k].id == students[i].id) {
						firstTime = false;
						break;
					}
				}
				if(firstTime) {
					result[dx] = students[i];
					dx++;
				}
			}
		}
		return result;
		
	}
	public static void printStudent(Student[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].id + " - " + arr[i].name + " - " + arr[i].rank);
		}
	}
	public static void main(String[] args) {
		Student[] students = getStudents();
		
		System.out.println("Danh sách sinh viên từng đạt loại A");
		Student[] listA = getStudentsTypeA(students);
		printStudent(listA);
	
		System.out.println("Danh sách sinh viên học lại (học > 1 lần)");
		Student[] retake = getsStudentsRetake(students);
		printStudent(retake);
	}
}
