package bt1;

public class Main {
	public static void main(String[] args) {
		
		Student sv1 = new Student(1, "Phạm Văn Huy", 9.0, 8.5);
		Student sv2 = new Student(2, "Ngô Châu Nhật Linh", 8.0, 9.5);
		Student sv3 = new Student();
		System.out.println("===Nhập thông tin của sv3===");
		sv3.input();
		
		Student[] students = {sv1, sv2 ,sv3 };
		
		System.out.println("===Tất cả các sinh viên===");
		for(Student s : students) {
			System.out.println(s.toString());
		}
		
		System.out.println("\n===Sinh viên có điểm trung bình > 8.5===");
		for(Student s : students) {
			if(s.averageScore() > 8.5) {
				System.out.println(s.toString());
			}
		}
		System.out.println("\n===Sinh viên có điểm lý thuyết lớn hơn điểm thực hành===");
		for(Student s : students) {
			if(s.getTheoryScore() > s.getPracticeScore()) {
				System.out.println(s.toString());
			}
		}
	}
}
