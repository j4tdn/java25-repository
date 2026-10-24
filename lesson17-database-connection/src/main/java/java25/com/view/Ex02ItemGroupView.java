package java25.com.view;

import java25.com.persistence.ItemGroup;
import java25.com.service.ItemGroupService;
import java25.com.service.ItemGroupServiceImpl;
import java25.com.service.ItemService;

import static java25.com.utils.PrintUtils.*;

public class Ex02ItemGroupView {
    private static ItemGroupService itemGroupService;

    static {
        itemGroupService = new ItemGroupServiceImpl();
    }

    public static void main(String[] args) {
//        generate(
//                "1. Liệt kê tất cả các loại hàng trong hệ thống",
//                itemGroupService.findAll()
//        );

//        generate(
//                "2. Liệt kê loại hàng theo mã loại",
//                itemGroupService.findById(1L)
//        );

//        generate(
//                "3. Liệt kê loại hàng theo tên loại",
//                itemGroupService.findByName("M")
//        );

//        generate(
//                "4. Liệt kê toàn bộ các loại hàng [kèm theo thông tin mặt hàng] có trong hệ thống",
//                itemGroupService.getItemGroups(),
//                ItemGroup::getItems
//        );

        generate(
                "6. Đếm số lượng mặt hàng của từng loại hàng",
                itemGroupService.countItemsPerGroup(3)
        );

    }
}
