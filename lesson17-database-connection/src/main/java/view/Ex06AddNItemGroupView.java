package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import enumeration.Status;
import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

import static utils.PrintUtils.generate;

public class Ex06AddNItemGroupView {

	/*
	09. Thực hiện thêm mới N loại hàng.
	*/

	private static final ItemGroupService itemGroupService = new ItemGroupServiceImpl();

	/**
	 *
	 * @param names danh sách tên các loại hàng cần thêm
	 * @param status trạng thái dùng cho các loại hàng mới
	 * @return danh sách loại hàng đã thêm thành công
	 */
	public static List<ItemGroup> addNItemGroups(List<String> names, Status status) {
		List<ItemGroup> result = new ArrayList<>();

		for (String name : names) {
			ItemGroup itemGroup = new ItemGroup(null, name, status);
			ItemGroup added = itemGroupService.insert(itemGroup);
			if (added != null) {
				result.add(added);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		List<String> names = Arrays.asList(
			"Phụ kiện",
			"Tai nghe"
		);

		List<ItemGroup> added = addNItemGroups(names, Status.Active);
		generate("09. Thêm mới N loại hàng", added);
	}
}
