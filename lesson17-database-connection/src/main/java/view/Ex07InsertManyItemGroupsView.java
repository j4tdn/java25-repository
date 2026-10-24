package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import enumeration.Status;
import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class Ex07InsertManyItemGroupsView {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Câu 9 - Nhập số loại hàng cần thêm (N, từ 1 đến 1000): ");
            int amount = Integer.parseInt(scanner.nextLine().trim());
            if (amount < 1 || amount > 1000) {
                throw new IllegalArgumentException("N phải nằm trong khoảng 1 đến 1000.");
            }

            System.out.print("Nhập tiền tố tên loại hàng (ví dụ: Loại mới): ");
            String prefix = scanner.nextLine().trim();
            if (prefix.isBlank()) {
                throw new IllegalArgumentException("Tiền tố không được để trống.");
            }

            System.out.print("Nhập mã bắt đầu (0 = MySQL tự sinh mã): ");
            long firstId = Long.parseLong(scanner.nextLine().trim());
            if (firstId < 0 || (firstId > 0 && firstId > Long.MAX_VALUE - amount)) {
                throw new IllegalArgumentException("Mã bắt đầu không hợp lệ.");
            }

            List<ItemGroup> groups = new ArrayList<>();
            for (int i = 1; i <= amount; i++) {
                Long id = firstId == 0 ? null : firstId + i - 1;
                groups.add(new ItemGroup(id, prefix + " " + i, Status.Active));
            }

            System.out.print("Sẽ thêm " + amount + " loại hàng vào MySQL. Xác nhận (y/n): ");
            if (!scanner.nextLine().trim().equalsIgnoreCase("y")) {
                System.out.println("Đã hủy.");
                return;
            }

            ItemGroupService service = new ItemGroupServiceImpl();
            int inserted = service.createMany(groups);
            System.out.println("Đã thêm thành công " + inserted + " loại hàng.");
        } catch (NumberFormatException ex) {
            System.out.println("N phải là số nguyên.");
        } catch (IllegalArgumentException | SQLException ex) {
            System.out.println("Không thể thêm hàng loạt: " + ex.getMessage());
        }
    }
}
