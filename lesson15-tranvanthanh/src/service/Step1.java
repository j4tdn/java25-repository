package service;

import java.math.BigDecimal;

public class Step1 {

	public boolean  execute( Integer planningAmount , Integer requiredminplanningamount) {
		
		BigDecimal planning = BigDecimal.valueOf(planningAmount);
		
		BigDecimal required = BigDecimal.valueOf(requiredminplanningamount);
		
		
			return planning.compareTo(required) > 0;
			
		
	}


	
	
}
