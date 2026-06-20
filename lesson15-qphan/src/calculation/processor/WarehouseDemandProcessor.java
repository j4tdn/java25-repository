package calculation.processor;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class WarehouseDemandProcessor implements Processor<Map<Long, BigDecimal>> {

	private Map<Long, BigDecimal> storeDemands;
	private Map<Long, Set<Long>> whStoreIds;

	private WarehouseDemandProcessor() {
	}

	public static WarehouseDemandProcessor of() {
		return new WarehouseDemandProcessor();
	}

	public WarehouseDemandProcessor withStoreDemands(Map<Long, BigDecimal> storeDemands) {
		this.storeDemands = storeDemands;
		return this;
	}

	public WarehouseDemandProcessor withWhStoreIds(Map<Long, Set<Long>> whStoreIds) {
		this.whStoreIds = whStoreIds;
		return this;
	}

	@Override
	public Map<Long, BigDecimal> process() {
		return whStoreIds.entrySet()
				.stream()
				.collect(Collectors.toMap(
						Entry::getKey,
						e -> e.getValue().stream()
								.map(storeDemands::get)
								.reduce(BigDecimal.ZERO, BigDecimal::add)
				));
	}

}
