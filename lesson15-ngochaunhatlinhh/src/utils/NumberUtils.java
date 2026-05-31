package utils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import bean.Store;
import model.WhData;
import view.WhAllocationDemo.StoreDemand;

public class NumberUtils {

	private NumberUtils() {
	}

	public static BigDecimal bd(double val) {
		return new BigDecimal(String.valueOf(val));
	}

	public static void printStores(String title, List<Store> stores) {
		System.out.println(title);
		for (Store s : stores) {
			String paddedId = (s.getId() < 10 ? " " : "") + s.getId();
			System.out.println("   Store " + paddedId + " (WH " + s.getWhId() + ") | Potential = " + s.getPotential());
		}
		System.out.println();
	}

	public static void printStoreDemands(String title, List<StoreDemand> demands) {
		System.out.println(title);
		System.out.println("   " + "-".repeat(90));
		for (StoreDemand sd : demands) {
			String paddedId = (sd.storeId() < 10 ? " " : "") + sd.storeId();
			System.out.println("   Store " + paddedId + " (WH " + sd.whId() + ") | Trend = " + sd.trend() + " | Demand = " + sd.demand());
		}
		System.out.println();
	}

	public static void printWhDemand(Map<Integer, WhData> whDataMap) {
		for (WhData wh : whDataMap.values()) {
			System.out.println("   WH " + wh.whId + " | Stores: " + wh.storeCount + " | Demand: " + wh.demand);
		}
		System.out.println();
	}

	public static void printWhShare(Map<Integer, WhData> whDataMap) {
		for (WhData wh : whDataMap.values()) {
			System.out.println("   WH " + wh.whId + " | Demand: " + wh.demand + " | Share: " + wh.share);
		}
		System.out.println();
	}

	public static void printWhAllocation(Map<Integer, WhData> whDataMap) {
		for (WhData wh : whDataMap.values()) {
			System.out.println("   WH " + wh.whId + " | Share: " + wh.share + " | Allocation: " + wh.allocation);
		}
		System.out.println();
	}
}
