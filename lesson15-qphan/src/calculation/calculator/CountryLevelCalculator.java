package calculation.calculator;

import calculation.context.CountryLevelContext;
import calculation.exception.CalculationException;
import calculation.parameter.RefItemStoreId;
import calculation.processor.FillingGapStorePotentialProcessor;
import calculation.processor.StoreDemandProcessor;
import calculation.result.WarehouseResult;
import calculation.validator.PlanningAmountValidator;

import static utils.LogUtils.*;

import java.math.BigDecimal;
import java.util.Map;

public class CountryLevelCalculator implements Calculator<WarehouseResult> {

	private final CountryLevelContext context;
	
	public CountryLevelCalculator(CountryLevelContext context) {
		this.context = context;
	}
	
	@Override
	public WarehouseResult calculate() throws CalculationException {
		
		final Integer planningAmount = context.getPlanningAmount();
		final Integer requiredMinPlanningAmount = context.getRequiredMinPlanningAmount();
		
		log("- Step 1: Check Mininum Planning Amount");
		PlanningAmountValidator planningAmountValidator = 
					new PlanningAmountValidator(planningAmount, requiredMinPlanningAmount);
		planningAmountValidator.validate();
		
		
		log("\n- Step 2: Filling gap by references or average");
		Map<RefItemStoreId, BigDecimal> refItemStorePotentials = FillingGapStorePotentialProcessor.of()
				.withReferenceItemStores(context.getRefItemStores())
				.withReferenceStores(context.getRefStores())
				.process();
		logRefItemStoreLevel(refItemStorePotentials, "StorePotential");
		
		log("\n- Step 3: Calculate Store Demands of Current Item");
		Map<Long, BigDecimal> storeDemands = StoreDemandProcessor.of()
				.withRefWeights(context.getRefWeights())
				.withStoreTrendFactors(context.getStoreTrendFactors())
				.withRefItemStorePotentials(refItemStorePotentials)
				.withStoreIds(context.getStoreIds())
				.process();
		logStoreLevel(storeDemands, "StoreDemand");
		
		return null;
	}

}
