package view;

import java.time.LocalDate;

import service.ItemService;
import service.ItemServiceImpl;

import static utils.PrintUtils.generate;

public class Ex03ItemView {

    private static final ItemService itemService = new ItemServiceImpl();

    public static void main(String[] args) {
        generate("1. Liet ke tat ca mat hang", itemService.getItems());

        generate(
                "2. Mat hang thuoc loai Giay, khong ban ngay 2026-10-24",
                itemService.getItemsByGroupAndNotSoldOnDate(
                        "Giày", LocalDate.of(2026, 10, 24))
        );
    }
}
