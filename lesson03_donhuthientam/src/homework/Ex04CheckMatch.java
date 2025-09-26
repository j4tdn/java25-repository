package homework;

import java.time.LocalDate;
import java.time.Period;

import bean.Person;

public class Ex04CheckMatch {
	public static void main(String[] args) {
		String[] hobbies1 = { "Múa hát", "Đọc sách", "Bóng đá", "Nghe nhạc", "Chạy Bộ" };
		String[] hobbies2 = { "CHẠY BỘ", "Bóng rổ", "MÚA HÁT", "đọc sách", "BÓNG ĐÁ" };

		Person p1 = new Person("TRAN VAN A", "NAM", "DA NANG", hobbies1, LocalDate.of(2002, 8, 31));
		Person p2 = new Person("TRAN THI B", "NU", "SAI GON", hobbies2, LocalDate.of(2010, 3, 20));

		if (checkGenderOrAge(p1, p2) && getHobby(p1, p2)) {
			System.out.println("Chúc mừng hai bạn đã hợp nhau. Các sở thích chung của 2 bạn:\n" );
			Hobbies(p1, p2);
		} else {
			System.out.println("Rất tiếc 2 bạn không hợp với nhau!");
		}
	}

	private static boolean checkGenderOrAge(Person p1, Person p2) {
		if (p1.getGender().equalsIgnoreCase(p2.getGender())) {
			return false;
		}
		int age1 = Period.between(p1.getBirthday(), LocalDate.now()).getYears();
		int age2 = Period.between(p2.getBirthday(), LocalDate.now()).getYears();
		return Math.abs(age1 - age2) <= 8;
	}

	private static void Hobbies(Person p1, Person p2) {
		String[] hobbies1 = p1.getHobbies();
		String[] hobbies2 = p2.getHobbies();
		for (String h1 : hobbies1) {
			for (String h2 : hobbies2) {
				if (h1.equalsIgnoreCase(h2)) {
					System.out.println(h1);
					break;
				}
			}
		}
	}

	private static boolean getHobby(Person p1, Person p2) {
		int count = 0;
		String[] hobbies1 = p1.getHobbies();
		String[] hobbies2 = p2.getHobbies();
		for (String h1 : hobbies1) {
			for (String h2 : hobbies2) {
				if (h1.equalsIgnoreCase(h2)) {
					count++;
					break;
				}
			}
		}
		return count >= 4;
	}
}
