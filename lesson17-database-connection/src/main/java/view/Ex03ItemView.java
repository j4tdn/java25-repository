package view;

import static utils.PrintUtils.generate;

import service.ItemService;
import service.ItemServiceImpl;

public class Ex03ItemView {
    private static ItemService itemService;

    static {
        itemService = new ItemServiceImpl();
    }

    public static void main(String[] args) {
        generate(
                "Liệt kê tất cả các mặt hàng kèm thông tin loại hàng",
                itemService.getItems()
        );
    }
}
