package exeption;

public class CalculationException extends RuntimeException {

	private static final long serialVersionUID = 6770692767476937453L;
	
	public CalculationException() {
		super("Error happens during execute the calculation")
	}
	
	public CalculationException(String message) {
		super(message);
	}

}
