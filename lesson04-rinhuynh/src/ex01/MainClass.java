package ex01;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Student sv1 = new Student(1, "Nguyen Van A", 9.0,8.5);
		Student sv2 = new Student(2, "Nguyen Van B", 8.0,8.0);
		
		Student sv3 = new Student();
		
		System.out.println("Enter infor student 3: ");
		
		System.out.print("Enter ID: ");
		sv3.setId(sc.nextInt());
		sc.nextLine();
		
		System.out.print("Enter name: ");
		sv3.setName(sc.nextLine());
		
		System.out.print("Enter Theory score: ");
		sv3.setTheoryScore(sc.nextDouble());
		
		System.out.print("Enter Practice score: ");
		sv3.setPracticeScore(sc.nextDouble());
		
		
		Student[] students = {sv1, sv2, sv3};
		
		System.out.println("\n======= Student List =======\n");
		for(Student s : students) {
			System.out.println(s);
		}
		
		System.out.println("\nStudent have theory score > practice score : \n");
		for (Student s : students) {
			if (s.getTheoryScore() > s.getPracticeScore()) {
				System.out.println("ID : " + s.getId() + " " + s.getName());
			}
		}
		
		sc.close();
	}

}
