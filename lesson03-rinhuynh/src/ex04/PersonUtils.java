package ex04;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.*;

public class PersonUtils {

	public static Person inputPerson(Scanner sc) {
	    System.out.print("Họ tên: ");
	    String name = sc.nextLine();

	    System.out.print("Giới tính (Nam/Nữ): ");
	    String gender = sc.nextLine();

	    System.out.print("Địa chỉ: ");
	    String address = sc.nextLine();

	    System.out.print("Năm sinh: ");
	    int birthYear = sc.nextInt();
	    sc.nextLine(); // clear buffer sau khi nhập số

	    System.out.print("Nhập sở thích (ngăn cách bởi dấu phẩy): ");
	    String[] hobbyArray = sc.nextLine().split(",");
	    List<String> hobbies = new ArrayList<>();
	    for (String h : hobbyArray) {
	        hobbies.add(normalize(h));
	    }

	    return new Person(name, gender, address, hobbies, birthYear);
	}

    // Hàm chuẩn hóa chuỗi
    public static String normalize(String s) {
        s = s.toLowerCase().trim(); // convert về chữ thường, bỏ khoảng trắng thừa
        s = Normalizer.normalize(s, Form.NFD); // tách dấu ra ký tự riêng
        s = s.replaceAll("\\p{M}", ""); // bỏ dấu tiếng Việt
        return s;
    }
    // Kiểm tra hợp nhau
    public static boolean isCompatible(Person p1, Person p2) {
        // 1. Khác giới tính
        if (p1.getGender().equalsIgnoreCase(p2.getGender())) return false;

        // 2. Tuổi chênh lệch <= 8
        if (Math.abs(p1.getAge() - p2.getAge()) > 8) return false;

        // 3. Có ít nhất 4 sở thích chung
        List<String> common = getCommonHobbies(p1, p2);
        return common.size() >= 4;
    }

    // Tìm sở thích chung
    public static List<String> getCommonHobbies(Person p1, Person p2) {
        List<String> common = new ArrayList<>();
        for (String h1 : p1.getHobbies()) {
            for (String h2 : p2.getHobbies()) {
                if (normalize(h1).equals(normalize(h2)) && !common.contains(h1)) {
                    common.add(h1);
                }
            }
        }
        return common;
    }
}
