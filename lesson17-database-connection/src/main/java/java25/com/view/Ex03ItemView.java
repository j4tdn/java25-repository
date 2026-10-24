package java25.com.view;

import java25.com.service.ItemService;
import java25.com.service.ItemServiceImpl;

import java.time.LocalDate;
import java.time.Month;

import static java25.com.utils.PrintUtils.*;

public class Ex03ItemView {
    private static ItemService itemService;

    static {
        itemService = new ItemServiceImpl();
    }

    public static void main(String[] args) {
//        generate(
//                "4. Liệt kê tất cả các loại hàng kèm thông tin mặt hàng",
//                itemService.getItems()
//        );

        generate(
                "7. -- 33. Liệt kê những mặt hàng là 'Áo' không bán được trong ngày 20/04/2026",
                itemService.getItemsByGroupAndNotSoldOnDate("Áo", LocalDate.of(2026, Month.APRIL,20))
        );
    }
}
