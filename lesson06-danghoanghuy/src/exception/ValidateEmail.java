package exception;

public class ValidateEmail {
	
	public static void validate(String email) throws IllegalArgumentException{
		
		if(!email.matches("^[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$")) throw new IllegalArgumentException("Email k hop le, NHAP LAI !!!!!!!!");
		
	}
	
}
