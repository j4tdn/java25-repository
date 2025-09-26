package bai4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập thông tin người 1:");
        Person p1 = nhapNguoi(sc);

        System.out.println("\nNhập thông tin người 2:");
        Person p2 = nhapNguoi(sc);

        if (p1.getGioiTinh()!=p2.getGioiTinh() && p1.getTuoi() - p2.getTuoi() <= 8) { //khác giới và chênh tuôi <= 8

        	// cho ds các sthich chung
            List<String> chung = new ArrayList<>();
            for (String st1 : p1.getSoThich()) {
                for (String st2 : p2.getSoThich()) {
                    if (st1.equals(st2) && !chung.contains(st1)) {// equal kiếm tra có giống k, k dùng == vì đây là so sánh chuỗi
                        chung.add(st1);                           // !chung.contains(st1)): nếu st1 chưa có trong chung
                    }
                }
            }

            if (chung.size() >= 4) {
                System.out.println("\nHai bạn hợp nhau!");
                System.out.println("Z1: " + p1);
                System.out.println("Z2: " + p2);
                System.out.println("Sở thích chung: " + chung);
                return;
            }
        }

        System.out.println("\nRất tiếc 2 bạn không hợp với nhau!");
    }

    private static Person nhapNguoi(Scanner sc) {
        System.out.print("Họ tên: ");
        String hoTen = sc.nextLine();

        System.out.print("Giới tính: ");
        String gioiTinh = sc.nextLine();

        System.out.print("Địa chỉ: ");
        String diaChi = sc.nextLine();

        System.out.print("Năm sinh: ");
        int namSinh = sc.nextInt();

        // split: cắt chuỗi thành mảng dựa trên dấu ,
        // Arrays.asList(arr) → chuyển mảng arr thành một danh sách List<String>
        System.out.print("Nhập danh sách sở thích (cách nhau bởi dấu phẩy): ");
        String[] arr = sc.nextLine().split(",");
        List<String> soThich = Arrays.asList(arr);

        return new Person(hoTen, gioiTinh, diaChi, soThich, namSinh);
    }
}
