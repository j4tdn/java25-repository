package exception;

public class CalculationException extends RuntimeException{
	/*
	 * 
	 * 
	 * 
	 * 
	 */
	private static final long serialVersionUID = 92;
	public CalculationException() {
		this("Error happens during execute the calculator ");
	}
	
	public CalculationException(String message) {
		super(message);
	}
}
