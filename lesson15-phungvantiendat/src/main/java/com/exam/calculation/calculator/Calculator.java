package com.exam.calculation.calculator;

import com.exam.calculation.exception.CalculationException;

/**
 * Xử lý cho toàn bộ calculation
 * R: kết quả trả về sau cùng của calculation
 */
public interface Calculator<R> {
    
    R calculate() throws CalculationException;
    
}
