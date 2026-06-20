package calculation.processor;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import static utils.NumberUtils.bd;

public class WarehouseApplyMinProcessor implements Processor<Map<Long, Integer>> {

	private Map<Long, BigDecimal> whAllocatedAmounts;
	private Integer minPerStore;
	private Map<Long, Set<Long>> whStoreIds;

	private WarehouseApplyMinProcessor() {
	}

	public static WarehouseApplyMinProcessor of() {
		return new WarehouseApplyMinProcessor();
	}

	public WarehouseApplyMinProcessor withWhAllocatedAmounts(Map<Long, BigDecimal> whAllocatedAmounts) {
		this.whAllocatedAmounts = whAllocatedAmounts;
		return this;
	}

	public WarehouseApplyMinProcessor withMinPerStore(Integer minPerStore) {
		this.minPerStore = minPerStore;
		return this;
	}

	public WarehouseApplyMinProcessor withWhStoreIds(Map<Long, Set<Long>> whStoreIds) {
		this.whStoreIds = whStoreIds;
		return this;
	}

	@Override
	public Map<Long, Integer> process() {
		final Map<Long, Integer> whMinAmounts = whStoreIds.entrySet()
				.stream()
				.collect(Collectors.toMap(Entry::getKey, e -> e.getValue().size() * minPerStore));
		
		// Kết quả chỉ lưu trữ các warehouse đã apply min
		return whAllocatedAmounts.entrySet()
				.stream()
				.filter(e -> {
					BigDecimal whAllocatedAmount = e.getValue();
					Integer whMinAmount = whMinAmounts.get(e.getKey());
					return whAllocatedAmount.compareTo(bd(whMinAmount)) < 0;
				})
				.collect(Collectors.toMap(Entry::getKey, e -> whMinAmounts.get(e.getKey())));
	}

}
