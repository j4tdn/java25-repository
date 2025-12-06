package exception;

public class CalculationException extends RuntimeException{
	private static final long serialVersionUID = 9216689430917781803L;
	
	public CalculationException() {
		super("Error happens during execute the calculation");
	}
	
	public CalculationException(String message) {
		super(message);
	}

}
