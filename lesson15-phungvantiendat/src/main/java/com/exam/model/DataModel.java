package com.exam.model;

import static com.exam.utils.NumberUtils.bd;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.exam.bean.Item;
import com.exam.bean.Store;

public class DataModel {

    // số mặt hàng tối thiểu cần cho một cửa hàng
	public static final Integer minPerStore = 5;

	// số lượng mặt hàng từ country(quốc gia) chuyển đến các warehouse(kho hàng)
	public static final Integer planningAmount = 88;

	// số lượng mặt hàng tối thiểu cần chuyển đi một lần từ country đến warehouse
	public static final Integer requiredMinPlanningAmount = 50;

	private DataModel() {
	}
	
	public static List<Long> mockItemStoreIds() {
		return LongStream.rangeClosed(1, 14).boxed().toList();
	}

	/**
	 * Dữ liệu test cho store potential của reference item A55
	 */

    public static Map<Item, List<Store>> mockStoresOfRefItemA55() {
		Item itemA55 = new Item(55L, "Item A55");
		List<Store> stores = List.of(
			new Store(1L, "Store 1", bd(21.9), 2),
			new Store(2L, "Store 2", bd(66.885), 1),
			new Store(3L, "Store 3", bd(10.5), 1),
			new Store(4L, "Store 4", bd(36.4), 1),
			new Store(5L, "Store 5", bd(14), 1),
			new Store(6L, "Store 6", bd(65.52), 1),
			new Store(7L, "Store 7", bd(17.9), 2),
			new Store(8L, "Store 8", bd(26.7), 2),
			new Store(9L, "Store 9", bd(54.9), 2),
			new Store(10L, "Store 10", bd(35), 2),
			new Store(11L, "Store 11", bd(22.7), 3),
			new Store(12L, "Store 12", bd(1), 3),
			new Store(13L, "Store 13", bd(19.1), 3),
			new Store(14L, "Store 14", bd(19.4), 3)
		);
		return Map.of(itemA55, stores);
	}
	
	public static Map<Long, BigDecimal> mockStoreTrendFactors() {
		return Map.of(
			2L, bd(1.2),
			7L, bd(1.5),
			11L, bd(0.9),
			12L, bd(0.7)
		);
	}

	/**
	 * Dữ liệu test cho store potential của reference item A77
	 */
	public static Map<Item, List<Store>> mockStoresOfRefItemA77() {
		Item itemA77 = new Item(77L, "Item A77");
		List<Store> stores = List.of(
			new Store(1L, "Store 1", bd(22.024), 2),
			new Store(2L, "Store 2", bd(150.777), 1),
			new Store(3L, "Store 3", bd(33.4), 1),
			new Store(4L, "Store 4", bd(23.4), 1),
			new Store(5L, "Store 5", bd(26.289), 1),
			new Store(6L, "Store 6", bd(22.2), 1),
			new Store(7L, "Store 7", bd(23.6), 2),
			new Store(8L, "Store 8", bd(21.9), 2),
			new Store(9L, "Store 9", bd(20.74), 2),
			new Store(10L, "Store 10", bd(0), 2),
			new Store(11L, "Store 11", bd(26.612), 3),
			new Store(12L, "Store 12", bd(0), 3),
			new Store(13L, "Store 13", bd(32.1), 3),
			new Store(14L, "Store 14", bd(22.5), 3)
		);
		return Map.of(itemA77, stores);
	}

	/**
	 * Dữ liệu test cho 'Reference Stores Data'
	 * + Store 7 có Reference Store 3
	 * + Store 10 có Reference Store 1
	 */
	public static Map<Long, Long> mockRefStores() {
		return Map.of(
				7L, 3L, 
				10L, 1L
		);
	}

    public static Map<Item,List<Store>> mockRefItemStores() {
        Map<Item, List<Store>> refItemStores = new HashMap<>(mockStoresOfRefItemA55());
        refItemStores.putAll(mockStoresOfRefItemA77());
        return refItemStores;
    }

	/**
	 * Dữ liệu test cho 'Weight(trọng số tham chiếu của mặt hàng) Of Reference Item'
	 * + Item A1 liên kết với Item 55(reference) với trọng số là 2.5
	 * + Item A1 liên kết với Item 77(reference) với trọng số là 1.5
	 */
	public static Map<Long, BigDecimal> mockRefWeights() {
		return Map.of(
			55L, bd(2.5),
			77L, bd(1.5)
		);
	}
}
