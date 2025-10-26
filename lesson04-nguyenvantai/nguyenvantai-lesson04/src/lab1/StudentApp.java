package lab1;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// sv1 và sv2 tạo bằng constructor đủ thông số
		Students sv1 = new Students(1, "Nguyễn Văn A", 8.8d, 9d);
		Students sv2 = new Students(2, "Nguyễn Văn B", 8.8d, 9d);
		Students sv3 = new Students();

		String name;

		String text;
		System.out.println("Nhập thông tin của sinh viên 3");
		System.out.printf("Nhập id: ");
		text = sc.nextLine();
		if (isNumber(text)) {
			sv3.setId(Integer.parseInt(text));
		}
		System.out.printf("Nhập tên của sinh viên: ");
		name = sc.nextLine();
		sv3.setName(name == null ? "" : name.trim());
		System.out.printf("Nhập điểm lý thuyết: ");
		text = sc.nextLine();
		if (isNumber(text)) {
			sv3.setTheoryScore(Double.parseDouble(text));
		}
		System.out.printf("Nhập điểm thực hành: ");
		text = sc.nextLine();
		if (isNumber(text)) {
			sv3.setPracticeScore(Double.parseDouble(text));
		}

		Students[] arr = { sv1, sv2, sv3 };
		System.out.println("Sinh viên có điểm trung bình lớn hơn 8.5");
		System.out.printf("%5s %15s %20s %30s \n", "ID", "NAME", "THEORYSCORE", "PRACTICESCORE");
		for (Students e : arr) {
			if (e.calculateAverageScore() > 8.5) {
				System.out.printf("%5d %15s %20.2f %30.2f \n", e.getId(), e.getName(), e.getTheoryScore(),
						e.getPracticeScore());
			}
		}

		System.out.println("Sinh viên có điểm lý thuyết cao hơn điểm thực hành");
		Students[] res = findTheoryHigherThanPractice(arr);
		System.out.printf("%5s %15s %20s %30s \n", "ID", "NAME", "THEORYSCORE", "PRACTICESCORE");
		for (Students e : res) {
			System.out.printf("%5d %15s %20.2f %30.2f \n", e.getId(), e.getName(), e.getTheoryScore(),
					e.getPracticeScore());

		}

		sc.close();

	}

	private static boolean isNumber(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (!Character.isDigit(text.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	private static Students[] findTheoryHigherThanPractice(Students[] arr) {
		int n = 0;
		int i = 0;
		for (Students e : arr) {
			if (e.getTheoryScore() > e.getPracticeScore()) {
				n++;
			}
		}
		Students[] result = new Students[n];

		for (Students e : arr) {
			if (e.getTheoryScore() > e.getPracticeScore()) {
				result[i++] = e;
			}
		}
		return result;
	}

}
