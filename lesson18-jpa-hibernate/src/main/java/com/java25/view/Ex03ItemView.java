package com.java25.view;

import com.java25.service.ItemService;
import com.java25.service.ItemServiceImpl;

import static com.java25.utils.PrintUtils.generate;

public class Ex03ItemView {
    private static ItemService itemService;

    static {
        itemService = new ItemServiceImpl();
    }

    public static void main(String[] args) {

//                generate(
//                "4. Liệt kê tất cả các loại hàng không kèm thông tin mặt hàng",
//                itemService.getAll()
//        );


                generate(
                "5. Liệt kê tất cả các loại hàng kèm thông tin mặt hàng",
                itemService.getItems()
        );
    }
}
