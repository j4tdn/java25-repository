package java25.com.view;

import java25.com.service.ItemGroupService;
import java25.com.service.ItemGroupServiceImpl;

import static java25.com.utils.PrintUtils.*;

public class Ex02ItemGroupView {
    private static ItemGroupService itemGroupService;

    static {
        itemGroupService = new ItemGroupServiceImpl();
    }

    public static void main(String[] args) {
        generate(
                "1. Liệt kê tất cả các loại hàng trong hệ thống",
                itemGroupService.findAll()
        );
    }
}
