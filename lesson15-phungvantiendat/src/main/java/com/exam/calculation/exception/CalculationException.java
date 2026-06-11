package com.exam.calculation.exception;

public class CalculationException extends Exception {

	private static final long serialVersionUID = 3809846384039530296L;

	/**
	 * Exception with default message
	 */
	public CalculationException() {
		super("Exception when trigger calculation");
	}

	/**
	 * Exception with custom message
	 */
	public CalculationException(String message) {
		super(message);
	}

}
