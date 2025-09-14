package datastructure.object;

public class CustomText {
	int numberOfLetters;
	String value;
	
	public CustomText(int numberOfLetters, String value) {
		this.numberOfLetters = numberOfLetters;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "CustomText [numberOfLetters=" + numberOfLetters + ", value=" + value + "]";
	}
}
