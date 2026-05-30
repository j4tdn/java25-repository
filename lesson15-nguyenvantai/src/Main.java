import java.util.ArrayList;
import java.util.List;

import model.Store;
import service.AllocationService;

public class Main {
	public static void main(String[] args) {
		List<Store> stores = new ArrayList<>();
		stores.add(new Store(1L, null, 18, 40.0, true));
		stores.add(new Store(2L, null, 19, 20.0, true));
		stores.add(new Store(3L, null, 21, 17.0, true));
		stores.add(new Store(4L, null, 14, 31.0, true));
		stores.add(new Store(5L, null, 14, 10.0, true));
		stores.add(new Store(6L, null, 15, 30.0, true));
		// 7 tham chiếu đến 2
		// 10 tham chiếu đến 7, nhưng 7 lấy dữ liệu của 2
		stores.add(new Store(7L, 2L, 15, null, true));
		stores.add(new Store(8L, null, 12, 19.0, true));
		stores.add(new Store(9L, null, 17, 26.0, true));
		stores.add(new Store(10L, 7L, 18, null, true));
		AllocationService service = new AllocationService();
		service.fillExpectedSales(stores);
		service.calculateAllocationKey(stores);
		service.calculatedAllocatedAmount(stores, 300);
		System.out.println("=====Result=====");
		stores.forEach(System.out::println);
	}
}
