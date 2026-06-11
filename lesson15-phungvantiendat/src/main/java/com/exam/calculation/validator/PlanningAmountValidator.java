package com.exam.calculation.validator;

import static com.exam.utils.LogUtils.log;

import com.exam.calculation.exception.CalculationException;
import com.exam.calculation.exception.MinimumAmountException;

public class PlanningAmountValidator implements Validator {

  private Integer planningAmount;
  private Integer requiredMinPlanningAmount;

  public PlanningAmountValidator(Integer planningAmount, Integer requiredMinPlanningAmount) {
    this.planningAmount = planningAmount;
    this.requiredMinPlanningAmount = requiredMinPlanningAmount;
  }

  @Override
  public void validate() throws CalculationException {
    if (planningAmount < requiredMinPlanningAmount) {
      throw new MinimumAmountException(
          "Planning Amount("
              + planningAmount
              + ") "
              + "is less then required min Planning Amount("
              + requiredMinPlanningAmount
              + ")");
    }
    log(
        ">>> Planning Amount (%s) is greater than " + "required min Planning Amount(%s)",
        planningAmount, requiredMinPlanningAmount);
  }
}
