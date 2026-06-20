package view;

import calculation.calculator.CountryLevelCalculator;
import calculation.context.CountryLevelContext;
import calculation.exception.CalculationException;

import static model.DataModel.*;

public class CountryLevelAllocationDemo {
	
	/**
	 * Bean, Exception
	 * 
	 * Context
	 * 
	 * Calculator
	 *   - Validator
	 *   - Processor
	 * 
	 * Result  
	 * 
	 * Context: Dữ liệu đầu vào của Calculator[dùng trong validator, processor]
	 *          Vì dữ liệu đầu vào có thể từ UI, file, database, third party ...
	 *          Lưu trên memory
	 *    
	 * Calculator: Công thức tổng hợp, chưa nhiều step được gọi khi cần phân phối hàng hóa
	 *           : Chứa 1 hoặc N bước, mỗi bước có thể là
	 *             - Validator: kiểm tra tính hợp lệ
	 *             - Processor: xử lý tính toán
	 * 
	 * Result: Kết quả trả về của mỗi Calculator
	 * 
	 * - Regex Pattern
	 * - Design Pattern
	 *   + Singleton
	 *   + Builder
	 *   + Factory
	 *   + Strategy
	 *   + ............
	 */
	
	public static void main(String[] args) {
		
		System.out.println("=== Fake UI, Start Calculation at Country Level\n");
		
		CountryLevelContext context = buildCountryLevelContext();
		
		try {
			CountryLevelCalculator calculator = new CountryLevelCalculator(context);
			calculator.calculate();
		} catch (CalculationException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\n=== Stop Calculation, Back to UI ===");
		
	}
	
	private static CountryLevelContext buildCountryLevelContext() {
		return CountryLevelContext.of()
				.withPlanningAmount(planningAmount)
				.withRequiredMinPlanningAmount(requiredMinPlanningAmount)
				.withMinPerStore(minPerStore)
				.withRefItemStores(mockReferenceItemStores())
				.withRefStores(mockRefStores())
				.withRefWeights(mockRefWeights())
				.withStoreTrendFactors(mockStoreTrendFactors())
				.withStoreIds(mockItemStoreIds())
				.withWhStoreIds(mockWhStoreIds());
	}
	
}
