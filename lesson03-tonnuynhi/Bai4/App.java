package Bai4;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {

	public static List<String> checkCompatibility(Person p1, Person p2) {

		// 1. Kiểm tra giới tính
		if (p1.getGender().equalsIgnoreCase(p2.getGender())) {
			System.out.println("-> Điều kiện 1: KHÔNG THỎA MÃN (Cùng giới tính)");
			return List.of();
		}

		// 2. Kiểm tra tuổi
		int currentYear = Year.now().getValue();
		int age1 = currentYear - p1.getBirthYear();
		int age2 = currentYear - p2.getBirthYear();

		long ageDiff = Math.abs(age1 - age2);

		if (ageDiff > 8) {
			System.out.println(
					"-> Điều kiện 2: KHÔNG THỎA MÃN (Chênh lệch tuổi > 8 năm. Chênh lệch: " + ageDiff + " năm)");
			return List.of();
		}

		// 3. Kiểm tra sở thích chung
		Set<String> hobbies1 = new HashSet<>(p1.getNormalizedHobbies());
		Set<String> hobbies2 = new HashSet<>(p2.getNormalizedHobbies());

		// Tìm giao của hai tập hợp sở thích chuẩn hóa
		hobbies1.retainAll(hobbies2);
		List<String> commonHobbies = new ArrayList<>(hobbies1);

		if (commonHobbies.size() < 4) {
			System.out.println(
					"-> Điều kiện 3: KHÔNG THỎA MÃN (Sở thích chung ít hơn 4. Chỉ có: " + commonHobbies.size() + ")");
			return List.of();
		}

		// Nếu tất cả thỏa mãn, trả về danh sách sở thích chung 
		System.out.println(" Thỏa mãn tất cả 3 điều kiện.");
		return commonHobbies;
	}

	public static void main(String[] args) {

		// Dữ liệu mẫu Z1 và Z2
		// Z1: Nữ, sinh 1995
		Person z1 = new Person("Nguyễn Thị Z1", "Nữ", "Hà Nội",
				List.of("Đọc sách", "Bóng đá", "Múa Hát", "Du lịch", "Mua sắm", "Game"), 1995);

		// Z2: Nam, sinh 1999. Chênh lệch 4 tuổi.
		Person z2 = new Person("Trần Văn Z2", "Nam", "Hồ Chí Minh",
				List.of("Đọc Sách", "Bóng Đá", "Múa Hát", "Du lịch", "Lập Trình", "Thể hình"), 1999);

		System.out.println("--- Kiểm tra Tình Duyên giữa Z1 và Z2 ---");

		List<String> resultHobbies = checkCompatibility(z1, z2);

		if (!resultHobbies.isEmpty()) {
			System.out.println("\n CHÚC MỪNG! 2 BẠN RẤT HỢP VỚI NHAU!");
			System.out.println("=============================================");
			System.out.println(z1);
			System.out.println(z2);
			System.out.println("Danh sách " + resultHobbies.size() + " sở thích chung (đã chuẩn hóa):");

			// In sở thích chung chuẩn hóa ra màn hình
			for (String hobby : resultHobbies) {
				System.out.println("- " + hobby);
			}

		} else {
			System.out.println("\n Rất tiếc 2 bạn không hợp với nhau !");
		}
	}
}