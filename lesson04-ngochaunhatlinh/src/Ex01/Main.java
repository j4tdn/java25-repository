package Ex01;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Student sv1 = new Student(1, "Ngô Châu Nhật Linh", 9.0, 8.0);
		Student sv2 = new Student(2, "Trịnh Trần Phương Tuấn", 5.0, 5.0);
	
		System.out.println("Input info sv3: ");
		Student sv3 = new Student();
		System.out.println("Input id: ");
		sv3.setId(Integer.parseInt(sc.nextLine()));
		System.out.println("Input full name: ");
		sv3.setFullName(sc.nextLine());
		System.out.println("Input theory point");
		sv3.setTheoryPoint(Double.parseDouble(sc.nextLine()));
		System.out.println("Input practice point: ");
		sv3.setPracticePoint(Double.parseDouble(sc.nextLine()));
		
		
		Student[] students = { sv1, sv2, sv3 };
		System.out.println("info all student");
		for(Student s : students) {
			System.out.println(s);
		}
		findInfoStudentHightAverage(students);
		findInfoStudentHightTheory(students);
		
	}
	public static void findInfoStudentHightAverage(Student[] students) {
		System.out.println("info student Average Point > 8,5: ");
		for(Student s : students) {
			if(s.getCaculateAverage() != null && s.getCaculateAverage() > 8.5) {
				System.out.println(s);
			}else {
				System.out.println("no find studen Average > 8.5");
			} 
		}
	}
	public static void findInfoStudentHightTheory(Student[] students) {
		System.out.println("info student theory point > practice point");
		for (Student s : students) {
            if (s.getTheoryPoint() != null && s.getPracticePoint() != null  && s.getTheoryPoint() > s.getPracticePoint()) {
                System.out.println(s);
            }
        }
	}
}
 

