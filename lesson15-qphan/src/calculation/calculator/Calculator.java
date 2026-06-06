package calculation.calculator;

import calculation.exception.CalculationException;

/**
 * Xử lý cho toàn bộ calculation
 * R: kết quả trả về sau cùng của calculation
 */
public interface Calculator<R> {
	
	R calculate() throws CalculationException;
	
}
