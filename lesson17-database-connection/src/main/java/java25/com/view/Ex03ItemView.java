package java25.com.view;

import java25.com.service.ItemService;
import java25.com.service.ItemServiceImpl;
import static java25.com.utils.PrintUtils.*;

public class Ex03ItemView {
    private static ItemService itemService;

    static {
        itemService = new ItemServiceImpl();
    }

    public static void main(String[] args) {
        generate(
                "4. Liệt kê tất cả các loại hàng kèm thông tin mặt hàng",
                itemService.getItems()
        );
    }
}
