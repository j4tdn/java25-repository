package ex04;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập người 1
        System.out.println("Nhập thông tin người 1:");
        Person p1 = PersonUtils.inputPerson(sc);

        // Nhập người 2
        System.out.println("\nNhập thông tin người 2:");
        Person p2 = PersonUtils.inputPerson(sc);

        // Kiểm tra hợp nhau
        if (PersonUtils.isCompatible(p1, p2)) {
            System.out.println("\n Hai bạn hợp nhau! Thông tin:");
            System.out.println(p1);
            System.out.println(p2);
            System.out.println("Sở thích chung: " + PersonUtils.getCommonHobbies(p1, p2));
        } else {
            System.out.println("\nRất tiếc 2 bạn không hợp với nhau!");
        }

        sc.close();
    }
}
