package calculation.validator;

import calculation.exception.CalculationException;

public interface Validator {
	
	void validate() throws CalculationException;
	
}
