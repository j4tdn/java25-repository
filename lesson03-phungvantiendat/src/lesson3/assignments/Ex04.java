package lesson3.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bean.Participant;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap thong tin cho nguoi tham gia thu nhat: ");
		System.out.println("Nhap ho ten nguoi tham gia thu nhat: ");
		String fullNameZ1 = sc.nextLine();
		System.out.println("Nhap gioi tinh nguoi tham gia thu nhat: ");
		String genderZ1 = sc.nextLine();
		System.out.println("Nhap dia chi nguoi tham gia thu nhat: ");
		String addressZ1 = sc.nextLine();
		System.out.println("Nhap so luong so thich cua nguoi thu nhat");
		int n = Integer.parseInt(sc.nextLine());
		List<String> hobbiesOfZ1 = new ArrayList<String>();
		System.out.println("Nhap so thich cua nguoi thu nhat");
		for(int i = 0;i<n;++i) {
			String hobby = InputUtils.normalize(sc.nextLine());
			hobbiesOfZ1.add(hobby);
		}
		System.out.println("Nhap ngay sinh cho nguoi thu nhat: ");
		String dateOfBirthZ1 = sc.nextLine();
		
		System.out.println("=================================");
		System.out.println("Nhap thong tin cho nguoi tham gia thu hai: ");
		System.out.println("Nhap ho ten nguoi tham gia thu hai: ");
		String fullNameZ2 = sc.nextLine();
		System.out.println("Nhap gioi tinh nguoi tham gia thu nhat: ");
		String genderZ2 = sc.nextLine();
		System.out.println("Nhap dia chi nguoi tham gia thu nhat: ");
		String addressZ2 = sc.nextLine();
		System.out.println("Nhap so luong so thich cua nguoi thu nhat");
		int m = Integer.parseInt(sc.nextLine());
		List<String> hobbiesOfZ2 = new ArrayList<String>();
		System.out.println("Nhap so thich cua nguoi thu nhat");
		for(int i = 0;i<m;++i) {
			String hobby = InputUtils.normalize(sc.nextLine());
			hobbiesOfZ2.add(hobby);
		}

		System.out.println("Nhap ngay sinh cho nguoi thu hai: ");
		String dateOfBirthZ2 = sc.nextLine();
		
		Participant z1 = new Participant(fullNameZ1, genderZ1, addressZ1, hobbiesOfZ1, dateOfBirthZ1);
		Participant z2 = new Participant(fullNameZ2, genderZ2, addressZ2, hobbiesOfZ2, dateOfBirthZ2);
		
		if(ParticipantUtils.isMatch(z1, z2)) {
			ParticipantUtils.printHobbies(z1, z2);
		}else {
			System.out.println("Rất tiếc 2 bạn không hợp với nhau !");
		}
		
	}

}
