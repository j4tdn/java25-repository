package calculation.calculator;

import calculation.context.CountryLevelContext;
import calculation.exception.CalculationException;
import calculation.parameter.RefItemStoreId;
import calculation.processor.FillingGapStorePotentialProcessor;
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
		
		
		log("- Step 2: Filling gap by references or average");
		Map<RefItemStoreId, BigDecimal> refItemStorePotentials = FillingGapStorePotentialProcessor.of()
				.withReferenceItemStores(context.getReferenceItemStores())
				.withReferenceStores(context.getReferenceStores())
				.process();
		// LOG: in kết quả
		
		
		return null;
	}

}
