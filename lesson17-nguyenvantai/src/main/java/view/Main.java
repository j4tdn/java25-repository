package view;

import java.util.List;
import java.util.Scanner;

import service.StudentService;

public class Main {
	public static void main(String[] args) {
		StudentService service = new StudentService();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n===== MENU =====");
			System.out.println("1. Liet ke hoc sinh theo class id");
			System.out.println("2. Lop co hoc sinh gioi Math >= 8 va Literature >= 8");
			System.out.println("3. Thong ke so hoc sinh moi lop");
			System.out.println("4. Hoc sinh co diem TB >= 8.2");
			System.out.println("5. Hoc sinh co diem TB cao nhat moi lop");
			System.out.println("0. Thoat");
			System.out.print("Chon: ");

			String choice = sc.nextLine().trim();
			try {
				switch (choice) {
				case "1":
					System.out.print("Nhap class id: ");
					int cid = Integer.parseInt(sc.nextLine().trim());
					print(service.getStudentsByClassId(cid));
					break;
				case "2":
					print(service.getClassesWithGoodMathAndLiterature());
					break;
				case "3":
					print(service.getStudentCountPerClass());
					break;
				case "4":
					print(service.getStudentsWithAverageAtLeast(8.2));
					break;
				case "5":
					print(service.getTopStudentOfEachClass());
					break;
				case "0":
					System.out.println("Tam biet!");
					return;
				default:
					System.out.println("Lua chon khong hop le.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Vui long nhap so.");
			} catch (Exception e) {
				System.out.println("Loi: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	private static <T> void print(List<T> list) {
		if (list.isEmpty()) {
			System.out.println("(Khong co ket qua)");
			return;
		}
		for (T item : list) {
			System.out.println(item);
		}
	}
}