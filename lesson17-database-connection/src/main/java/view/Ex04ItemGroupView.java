package view;

import java.util.Arrays;
import java.util.List;

import enumeration.Status;
import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

public class Ex04ItemGroupView {

    public static void main(String[] args) {
        ItemGroupService service = new ItemGroupServiceImpl();

        System.out.println("Bai 8 - Them moi loai hang");
        ItemGroup newGroup = new ItemGroup(null, "Do gia dung", Status.Active);
        System.out.println("Them thanh cong: " + service.add(newGroup));

        System.out.println("Bai 8 - Sua loai hang");
        ItemGroup groupToUpdate = service.get("Do gia dung");
        if (groupToUpdate != null) {
            groupToUpdate.setName("Do gia dung moi");
            groupToUpdate.setStatus(Status.Active);
            System.out.println("Sua thanh cong: " + service.update(groupToUpdate));
        } else {
            System.out.println("Khong tim thay loai hang de sua.");
        }

        System.out.println("Bai 9 - Them moi N loai hang");
        List<ItemGroup> groups = Arrays.asList(
                new ItemGroup(null, "Do dien tu", Status.Active),
                new ItemGroup(null, "Do the thao", Status.Active),
                new ItemGroup(null, "Do hoc tap", Status.Active)
        );

        int count = service.addAll(groups);
        System.out.println("So loai hang them thanh cong: " + count);
    }
}
