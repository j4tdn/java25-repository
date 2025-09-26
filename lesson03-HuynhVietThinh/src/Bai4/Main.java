package Bai4;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập thông tin người thứ nhất:");
        Person z1 = inputPerson(scanner);

        System.out.println("\nNhập thông tin người thứ hai:");
        Person z2 = inputPerson(scanner);

        boolean genderCompatible = !z1.getGender().equals(z2.getGender());
        int ageDiff = z1.getAgeDifference(z2);
        List<String> commonHobbies = z1.getCommonHobbies(z2);

        if (genderCompatible && ageDiff <= 8 && commonHobbies.size() >= 4) {
            System.out.println("\n🎉 Hai bạn hợp nhau! Thông tin chi tiết:");
            System.out.println("\n👤 Người 1:");
            z1.printInfo();
            System.out.println("\n👤 Người 2:");
            z2.printInfo();
            System.out.println("\n💞 Sở thích chung:");
            for (String hobby : commonHobbies) {
                System.out.println("- " + hobby);
            }
        } else {
            System.out.println("\nRất tiếc 2 bạn không hợp với nhau !");
        }

        scanner.close();
    }

    private static Person inputPerson(Scanner scanner) {
        System.out.print("Họ tên: ");
        String name = scanner.nextLine();

        System.out.print("Giới tính (nam/nữ): ");
        String gender = scanner.nextLine();

        System.out.print("Địa chỉ: ");
        String address = scanner.nextLine();

        System.out.print("Ngày sinh (yyyy-mm-dd): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Nhập danh sách sở thích (cách nhau bởi dấu phẩy): ");
        String[] hobbiesArray = scanner.nextLine().split(",");
        List<String> hobbies = new ArrayList<>();
        for (String h : hobbiesArray) {
            hobbies.add(h.trim());
        }

        return new Person(name, gender, address, hobbies, birthDate);
    }
}
