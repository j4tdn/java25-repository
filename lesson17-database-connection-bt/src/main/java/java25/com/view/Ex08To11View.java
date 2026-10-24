package java25.com.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java25.com.common.Status;
import java25.com.persistence.ItemGroup;
import java25.com.persistence.CustomerAccount;
import java25.com.service.*;

public class Ex08To11View {
    private static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            ItemGroupService groups = new ItemGroupServiceImpl();
            CustomerAccountService accounts = new CustomerAccountServiceImpl();
            while (true) {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Bai 8: Them 1 loai hang");
                System.out.println("2. Bai 8: Sua 1 loai hang");
                System.out.println("3. Bai 8: Them/Sua theo ma loai");
                System.out.println("4. Bai 9: Them N loai hang");
                System.out.println("5. Bai 10: Tao tai khoan khach hang");
                System.out.println("6. Bai 11: Dang nhap");
                System.out.println("7. Xem danh sach loai hang");
                System.out.println("0. Thoat");
                String choice = read("Chon: ");
                if (choice.equals("0")) break;
                try {
                    switch (choice) {
                        case "1":
                            groups.insert(readGroup());
                            System.out.println("Them thanh cong.");
                            break;
                        case "2":
                            int updated = groups.update(readGroup());
                            System.out.println(updated > 0 ? "Da cap nhat." : "Khong co dong thay doi; kiem tra ma loai.");
                            break;
                        case "3":
                            groups.save(readGroup());
                            System.out.println("Da luu loai hang.");
                            break;
                        case "4":
                            int n = Integer.parseInt(read("Nhap so loai hang (1-1000): "));
                            if (n < 1 || n > 1000) throw new IllegalArgumentException("N phai tu 1 den 1000.");
                            List<ItemGroup> list = new ArrayList<>();
                            for (int i = 0; i < n; i++) {
                                System.out.println("Loai hang thu " + (i + 1));
                                list.add(readGroup());
                            }
                            System.out.println("Da them " + groups.insertBatch(list) + " loai hang.");
                            break;
                        case "5":
                            String name = read("Ho ten: ");
                            String email = read("Email: ");
                            String password = readPassword("Mat khau (8-128 ky tu): ");
                            CustomerAccount created = accounts.register(name, email, password);
                            System.out.println("Tao tai khoan thanh cong: " + created);
                            break;
                        case "6":
                            CustomerAccount account = accounts.login(read("Email: "), readPassword("Mat khau: "));
                            System.out.println(account == null ? "Email hoac mat khau khong dung."
                                    : "Dang nhap thanh cong. Xin chao " + account.getFullName());
                            break;
                        case "7":
                            for (ItemGroup group : groups.findAll()) System.out.println(group);
                            break;
                        default:
                            System.out.println("Lua chon khong hop le.");
                    }
                } catch (RuntimeException e) {
                    System.out.println("Loi: " + e.getMessage());
                }
            }
        } catch (RuntimeException e) {
            System.out.println("Khong khoi dong duoc: ");
            System.out.println("");
        }
    }

    private static String read(String label) {
        System.out.print(label);
        return INPUT.nextLine();
    }

    private static String readPassword(String label) {
        if (System.console() != null) {
            char[] chars = System.console().readPassword("%s", label);
            if (chars == null) throw new IllegalArgumentException("Chua nhap mat khau.");
            String password = new String(chars);
            java.util.Arrays.fill(chars, '\0');
            return password;
        }
        return read(label);
    }

    private static ItemGroup readGroup() {
        long id = Long.parseLong(read("Ma loai (> 0): "));
        String name = read("Ten loai: ");
        int status = Integer.parseInt(read("Trang thai (1: hoat dong, 0: ngung): "));
        if (status != 0 && status != 1) throw new IllegalArgumentException("Trang thai chi nhan 0 hoac 1.");
        return new ItemGroup(id, name, status == 1 ? Status.Active : Status.Disabled);
    }
}
