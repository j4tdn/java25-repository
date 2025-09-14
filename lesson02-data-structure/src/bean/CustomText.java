package bean;

public class CustomText {
	private final String text;
	
	public CustomText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "CustomText [text=" + text + "]";
	}

	public String getText() {
		return text;
	}

	

}
