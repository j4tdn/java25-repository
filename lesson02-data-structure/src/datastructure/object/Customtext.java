package datastructure.object;

public class Customtext {
	int numberOfLetter;
	String value;
	
	
	public Customtext(int numberOfLetter, String value) {
		this.numberOfLetter = numberOfLetter;
		this.value = value;
	}


	@Override
	public String toString() {
		return "Customtext [numberOfLetter=" + numberOfLetter + ", value=" + value + "]";
	}
	
	
	

}
