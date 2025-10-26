package bai1;


import java.util.Scanner;

public class ManagementOfStudents {
	
	
	
	
	public static void main(String[] args) {
		
		InforOfStudents sv1 = new InforOfStudents(234,"Le Cong Vinh",9.8f,10.0f);
		InforOfStudents sv2 = new InforOfStudents(025,"NV Thanh Huyen",8.5f,8f);
		System.out.println("Thông tin sv1 là: "+sv1);
		System.out.println("Thông tin sv2 là: "+sv2);
		InforOfStudents sv3 = InforOfSv();
		
		InforOfStudents[] list = {sv1,sv2,sv3};
		System.out.println("thông tin sinh viên có điểm trung bình lớn hơn 8.5");
		MatchingAvar(list);
		System.out.println("thông tin sinh viên có điểm lý thuyết lớn hơn điểm thực hành");

		Matchingcondition(list);
	}
	
private static InforOfStudents InforOfSv() {
	InforOfStudents sv = new InforOfStudents();
	
	Scanner sc = new Scanner(System.in);
	
	System.out.print("Nhập ID: ");
	int ID = Integer.parseInt(sc.nextLine());
	sv.setId(ID);
	
	System.out.print("Nhập tên:");
	String fullname =sc.nextLine();
	sv.setName(fullname);
	
	System.out.print("Nhập điểm lý thuyết: ");
	float theoPoint = Float.parseFloat(sc.nextLine());
	sv.setTheoScore(theoPoint);
	
	System.out.print("Nhập điểm thực hành:");
	float practPoint = Float.parseFloat(sc.nextLine());
	sv.setPractScore(practPoint);
	
	return sv;
	
	
}

private static void MatchingAvar(InforOfStudents[] students) {
	for(int i = 0;i<students.length;i++) {
		if(students[i].AvarScoretGreaterThan8()) {
			System.out.println(students[i]);
		}
	}
}
private static void Matchingcondition(InforOfStudents[] students) {
	for(int i = 0;i<students.length;i++) {
		if(students[i].TheoGreaterThanPract()) {
			System.out.println(students[i]);
		}
	}
}

}
