package com.exam.calculation.calculator;

import static com.exam.utils.LogUtils.*;


import java.math.BigDecimal;
import java.util.Map;

import com.exam.calculation.context.CountryLevelContext;
import com.exam.calculation.exception.CalculationException;
import com.exam.calculation.parameter.RefItemStoreId;
import com.exam.calculation.processor.FillingGapStorePotentialProcessor;
import com.exam.calculation.processor.StoreDemandProcessor;
import com.exam.calculation.result.WarehouseResult;
import com.exam.calculation.validator.PlanningAmountValidator;

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
                        .withReferenceStores(context.getReferenceStores())
                        .withReferenceItemStores(context.getReferenceItemStores())
                        .process();
        logRefItemStoreLevel(refItemStorePotentials, "StorePotential");
		
        log("\n- Step 3: Calculate Store Demands of Current Items");
        Map<Long, BigDecimal> storeDemands = StoreDemandProcessor.of()
                        .withRefItemStorePotentials(refItemStorePotentials)
                        .withRefWeights(context.getRefWeights())
                        .withStoreTrendFactors(context.getStoreTrendFactors())
                        .withStoreIds(context.getStoreIds())
                        .process();
        logStoreLevel(storeDemands, "StoreDemand");
		
		return null;
	}

}
