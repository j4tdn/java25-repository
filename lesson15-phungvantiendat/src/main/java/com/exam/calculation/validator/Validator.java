package com.exam.calculation.validator;

import com.exam.calculation.exception.CalculationException;

public interface Validator {
	
	void validate() throws CalculationException;
	
}
