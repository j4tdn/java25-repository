package calculation.calculator;

import calculation.context.CountryLevelContext;
import calculation.exception.CalculationException;
import calculation.parameter.RefItemStoreId;
import calculation.processor.StoreFillingGapPotentialProcessor;
import calculation.processor.WarehouseAllocateByShareProcessor;
import calculation.processor.WarehouseApplyMinProcessor;
import calculation.processor.StoreDemandProcessor;
import calculation.processor.WarehouseDemandProcessor;
import calculation.processor.WarehouseReallocateProcessor;
import calculation.processor.WarehouseRecalculateShareProcessor;
import calculation.processor.WarehouseRoundUpAmountProcessor;
import calculation.processor.WarehouseShareInPercentProcessor;
import calculation.result.WarehouseResult;
import calculation.validator.PlanningAmountValidator;

import static utils.LogUtils.*;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public class CountryLevelCalculator implements Calculator<WarehouseResult> {

	private final CountryLevelContext context;
	
	public CountryLevelCalculator(CountryLevelContext context) {
		this.context = context;
	}
	
	@Override
	public WarehouseResult calculate() throws CalculationException {
		
		Integer planningAmount = context.getPlanningAmount();
		Integer requiredMinPlanningAmount = context.getRequiredMinPlanningAmount();
		Map<Long, Set<Long>> whStoreIds = context.getWhStoreIds();
		
		log("- Step 1: Check Mininum Planning Amount");
		PlanningAmountValidator planningAmountValidator = new PlanningAmountValidator(planningAmount, requiredMinPlanningAmount);
		planningAmountValidator.validate();
		
		
		log("\n- Step 2: Filling gap by references or average");
		Map<RefItemStoreId, BigDecimal> refItemStorePotentials = StoreFillingGapPotentialProcessor.of()
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
		
		log("\n- Step 4: Sum up Demand to WH level");
		Map<Long, BigDecimal> whDemands = WarehouseDemandProcessor.of()
				.withStoreDemands(storeDemands)
				.withWhStoreIds(whStoreIds)
				.process();
		logWhLevel(whDemands, "WhDemand");
		
		log("\n- Step 5: Calculate Shares");
		Map<Long, BigDecimal> whShares = WarehouseShareInPercentProcessor.of()
				.withWhDemands(whDemands)
				.process();
		logWhLevel(whShares, "ShareInPercent(%)");
		
		log("\n- Step 6: Allocate By Shares");
		Map<Long, BigDecimal> whAllocatedAmounts = WarehouseAllocateByShareProcessor.of()
				.withPlanningAmount(planningAmount)
				.withWhShares(whShares)
				.process();
		logWhLevel(whAllocatedAmounts, "AllocatedAmount");
		
		log("\n- Step 7: Apply Minimum");
		Map<Long, Integer> whAppliedMins = WarehouseApplyMinProcessor.of()
				.withWhAllocatedAmounts(whAllocatedAmounts)
				.withMinPerStore(context.getMinPerStore())
				.withWhStoreIds(whStoreIds)
				.process();
		
		if (whAppliedMins.isEmpty()) {
			log("*** All warehouses are passed minimum amount validation");
			log("*** Skip recalculate share(step 8) and rellocate(step 9) and jump round up (step 10)");
		} else {
			logWhLevel(whAppliedMins, "AppliedMin");
			
			log("\n- Step 8: Recalculate Share");
			Map<Long, BigDecimal> whRecalculatedShares = WarehouseRecalculateShareProcessor.of()
				.withWhAllocatedAmounts(whAllocatedAmounts)
				.withWhAppliedMins(whAppliedMins)
				.process();
			logWhLevel(whRecalculatedShares, "RecalculatedShare(%)");
			
			log("\n- Step 9: Reallocate");
			whAllocatedAmounts = WarehouseReallocateProcessor.of()
					.withPlanningAmount(planningAmount)
					.withWhAllocatedAmounts(whAllocatedAmounts)
					.withWhAppliedMins(whAppliedMins)
					.withWhRecalculatedShares(whRecalculatedShares)
					.process();
			logWhLevel(whAllocatedAmounts, "(Re)AllocatedAmount");
		}
		
		log("\n- Step 10: Round Up");
		Map<Long, Integer> whRoundedUpAllocatedAmounts = WarehouseRoundUpAmountProcessor.of()
				.withWhAllocatedAmounts(whAllocatedAmounts)
				.process();
		logWhLevel(whRoundedUpAllocatedAmounts, "RoundUpAllocatedAmount");
		
		log("\n- Step 11: Fix Rounding Issues");
		
		return null;
	}

}
