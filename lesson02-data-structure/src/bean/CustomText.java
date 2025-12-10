package bean;

public class CustomText {
	private final String text; // reflection

//	public CustomText() {
//		
//	}
	
	public CustomText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	@Override
	public String toString() {
		return "CustomText[" + this.text + "]";
	}
	
	

}
