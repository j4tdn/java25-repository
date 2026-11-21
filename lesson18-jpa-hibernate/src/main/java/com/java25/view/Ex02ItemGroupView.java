package com.java25.view;

import com.java25.common.Status;
import com.java25.persistence.ItemGroup;
import com.java25.service.ItemGroupService;
import com.java25.service.ItemGroupServiceImpl;

import java.util.List;

import static com.java25.utils.PrintUtils.*;

public class Ex02ItemGroupView {
    private static ItemGroupService itemGroupService;

    static {
        itemGroupService = new ItemGroupServiceImpl();
    }

    public static void main(String[] args) {
//        generate(
//                "1. Liệt kê tất cả các loại hàng trong hệ thống",
//                itemGroupService.getAll()
//        );

//        generate(
//                "2. Liệt kê loại hàng theo mã loại",
//                itemGroupService.get(1L)
//        );

        generate(
                "3. Liệt kê loại hàng theo tên loại",
                itemGroupService.get("Áo")
        );

    }
}
