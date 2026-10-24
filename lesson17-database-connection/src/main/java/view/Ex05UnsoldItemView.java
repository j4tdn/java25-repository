package view;

import static utils.PrintUtils.generate;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import service.ItemService;
import service.ItemServiceImpl;

public class Ex05UnsoldItemView {

    public static void main(String[] args) {
       
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhập tên loại hàng (p1): ");
            String groupName = scanner.nextLine().trim();
            if (groupName.isEmpty()) {
                System.out.println("Tên loại hàng không được để trống.");
                return;
            }

            System.out.print("Nhập ngày (p2, yyyy-MM-dd): ");
            String dateText = scanner.nextLine().trim();
            LocalDate orderDate;
            try {
                orderDate = LocalDate.parse(dateText);
            } catch (DateTimeParseException ex) {
                System.out.println("Ngày không hợp lệ. Ví dụ đúng: 2026-10-24");
                return;
            }

            ItemService itemService = new ItemServiceImpl();
            generate(
                    "7. Mặt hàng thuộc loại '" + groupName + "' không bán trong ngày " + orderDate,
                    itemService.getItemsByGroupAndNotSoldOnDate(groupName, orderDate)
            );
        }
    }
}
