package bean;

public class CustomInt {
	public int value;

	public CustomInt(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "" + value;
	}
}
