package service;

public class PlanningAmountService {

	public static boolean isValidPlanningAmount(Integer planningAmount, Integer requiredMinPlanningAmount) {
		return planningAmount > requiredMinPlanningAmount;
	}

}
