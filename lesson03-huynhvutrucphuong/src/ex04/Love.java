package ex04;

import java.util.Scanner;


import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Love {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập Z1
        System.out.print("Nhập tên Z1: ");
        String name1 = sc.nextLine();
        System.out.print("Nhập giới tính Z1 (Nam/Nữ): ");
        String gender1 = sc.nextLine();
        System.out.print("Nhập địa chỉ Z1: ");
        String address1 = sc.nextLine();
        System.out.print("Nhập danh sách sở thích Z1 (cách nhau bởi dấu phẩy): ");
        List<String> hobbies1 = Arrays.asList(sc.nextLine().split(","));
        System.out.print("Nhập ngày sinh Z1 (yyyy-mm-dd): ");
        LocalDate birth1 = LocalDate.parse(sc.nextLine());

        Person z1 = new Person(name1, gender1, address1, hobbies1, birth1);

        // Nhập Z2
        System.out.print("\nNhập tên Z2: ");
        String name2 = sc.nextLine();
        System.out.print("Nhập giới tính Z2 (Nam/Nữ): ");
        String gender2 = sc.nextLine();
        System.out.print("Nhập địa chỉ Z2: ");
        String address2 = sc.nextLine();
        System.out.print("Nhập danh sách sở thích Z2 (cách nhau bởi dấu phẩy): ");
        List<String> hobbies2 = Arrays.asList(sc.nextLine().split(","));
        System.out.print("Nhập ngày sinh Z2 (yyyy-mm-dd): ");
        LocalDate birth2 = LocalDate.parse(sc.nextLine());

        Person z2 = new Person(name2, gender2, address2, hobbies2, birth2);


        if (!z1.getGender().equalsIgnoreCase(z2.getGender())) {
            int ageDiff = Math.abs(Period.between(z1.getBirthDate(), z2.getBirthDate()).getYears());
            if (ageDiff <= 8) {
                Set<String> common = new HashSet<>(z1.getHobbies());
                common.retainAll(z2.getHobbies());

                if (common.size() >= 4) {
                    System.out.println("\nHai bạn hợp nhau!");
                    System.out.println(z1);
                    System.out.println(z2);
                    System.out.println("Sở thích chung: " + common);
                    return;
                }
            }
        }
        System.out.println("\nRất tiếc 2 bạn không hợp với nhau !");
    }

}
