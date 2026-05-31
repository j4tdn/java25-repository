package service;

import model.DataModel;

public class Step1 {
	public boolean execute() {
		System.out.println("=== Step 1: Check for plannning amount ===");

		Integer planningAmount = DataModel.planningAmount;
		Integer requiredMinPlanningAmount = DataModel.requiredMinPlanningAmount;

		System.out.println("Planning Amount Country: " + planningAmount);
		System.out.println("Required Min Planning Amount: " + requiredMinPlanningAmount);

		if (planningAmount <= requiredMinPlanningAmount) {
			System.out.println("Result Status: STOP ");
			return false;
		}
		System.out.println("Result Status: OK");
		return true;

	}

}
