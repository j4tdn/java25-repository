package view;

import java.sql.SQLException;
import java.util.Scanner;

import enumeration.Status;
import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class Ex06ItemGroupCrudView {

    public static void main(String[] args) {
        ItemGroupService service = new ItemGroupServiceImpl();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Câu 8 - Quản lý loại hàng");
            System.out.println("1. Thêm loại hàng");
            System.out.println("2. Sửa loại hàng theo mã");
            System.out.println("3. Thêm hoặc sửa loại hàng (upsert)");
            System.out.print("Chọn chức năng (1-3): ");
            int choice = Integer.parseInt(scanner.nextLine().trim());

            Long id = null;
            if (choice == 1 || choice == 2 || choice == 3) {
                System.out.print("Nhập mã loại hàng (0 = tự sinh, chỉ áp dụng mục 1 hoặc 3): ");
                long inputId = Long.parseLong(scanner.nextLine().trim());
                if (inputId > 0) {
                    id = inputId;
                } else if (choice == 2 || inputId < 0) {
                    throw new IllegalArgumentException("Mã loại hàng không hợp lệ.");
                }
            } else {
                throw new IllegalArgumentException("Chỉ chọn 1, 2 hoặc 3.");
            }

            System.out.print("Nhập tên loại hàng: ");
            String name = scanner.nextLine().trim();
            System.out.print("Trạng thái (1 = Active, 0 = Disabled): ");
            int statusValue = Integer.parseInt(scanner.nextLine().trim());
            if (statusValue != 0 && statusValue != 1) {
                throw new IllegalArgumentException("Trạng thái chỉ được là 0 hoặc 1.");
            }

            ItemGroup group = new ItemGroup(id, name,
                    statusValue == 1 ? Status.Active : Status.Disabled);
            if (choice == 1) {
                System.out.println("Đã thêm: " + service.create(group));
            } else if (choice == 2) {
                System.out.println(service.update(group)
                        ? "Đã sửa: " + group
                        : "Không tìm thấy loại hàng có mã " + id);
            } else {
                System.out.println("Đã thêm/cập nhật: " + service.save(group));
            }
        } catch (NumberFormatException ex) {
            System.out.println("Bạn cần nhập số hợp lệ.");
        } catch (IllegalArgumentException | SQLException ex) {
            System.out.println("Không thực hiện được: " + ex.getMessage());
        }
    }
}
