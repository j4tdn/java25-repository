package view;

import static utils.PrintUtils.generate;

import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class Ex04ItemGroupCountView {

    public static void main(String[] args) {
     
        int minAmount = 20;
        ItemGroupService itemGroupService = new ItemGroupServiceImpl();

        generate(
                "6. Loại hàng có số lượng mặt hàng > " + minAmount,
                itemGroupService.countItemsPerGroup(minAmount)
        );
    }
}
