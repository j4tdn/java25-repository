package view;

import enumeration.Status;
import persistence.ItemGroup;
import service.ItemGroupService;
import service.ItemGroupServiceImpl;

import static utils.PrintUtils.generate;

/*
08. CRUD loại hàng.
 */
public class Ex05CRUDItemGroupView {

	private static final ItemGroupService itemGroupService = new ItemGroupServiceImpl();

	/**
	 * Thêm mới một loại hàng.
	 *
	 * @param name tên loại hàng
	 * @param status trạng thái loại hàng
	 * @return loại hàng sau khi thêm
	 */
	public static ItemGroup addItemGroup(String name, Status status) {
		ItemGroup itemGroup = new ItemGroup(null, name, status);
		return itemGroupService.insert(itemGroup);
	}

	/**
	 * Sửa một loại hàng theo mã loại.
	 *
	 * @param id mã loại hàng
	 * @param name tên mới
	 * @param status trạng thái mới
	 * @return loại hàng sau khi sửa
	 */
	public static ItemGroup updateItemGroup(Long id, String name, Status status) {
		ItemGroup itemGroup = new ItemGroup(id, name, status);
		return itemGroupService.update(itemGroup);
	}

	/**
	 * Thêm nếu chưa có mã, sửa nếu đã có mã.
	 *
	 * @param itemGroup loại hàng cần lưu
	 * @return loại hàng sau khi lưu
	 */
	public static ItemGroup saveItemGroup(ItemGroup itemGroup) {
		return itemGroupService.save(itemGroup);
	}

	public static void main(String[] args) {
		// 08.1. Thêm mới 1 loại hàng.
		ItemGroup added = addItemGroup("Dép", Status.Active);
		generate("08.1. Thêm mới 1 loại hàng", added);

		if (added == null) {
			return;
		}

		// 08.2. Sửa 1 loại hàng vừa thêm.
		ItemGroup updated = updateItemGroup(
			added.getId(),
			"Dép",
			Status.Disabled
		);
		generate("08.2. Sửa 1 loại hàng", updated);

		// 08.3. save() tự chọn thêm hoặc sửa dựa vào id.
		ItemGroup saved = saveItemGroup(
			new ItemGroup(null, "Găng tay", Status.Disabled)
		);
		generate("08.3. Thêm/sửa 1 loại hàng", saved);
	}
}
