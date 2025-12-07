package exception;

public class ValidatePassword {
	
	public static void validate(String pw) throws IllegalArgumentException{

		if(pw == null || pw.length() < 8) throw new IllegalArgumentException("Can it nhat 8 ki tu");
		if(pw.length() > 257) throw new IllegalArgumentException("Toi da 256 ki tu");
		if(!pw.matches(".*[a-z].*")) throw new IllegalArgumentException("It nhat 1 chu in thuong");
		if(!pw.matches(".*[A-Z].*")) throw new IllegalArgumentException("It nhat 1 chu in hoa");
		if(!pw.matches(".*[0-9].*")) throw new IllegalArgumentException("It nhat 1 chu so");
		if(!pw.matches(".*[~!@#$%^&*()\\\\-_=+\\\\[\\\\]{}|;:,.<>/?].*")) throw new IllegalArgumentException("It nhat 1 ki tu dac biet");
	}
	
}
