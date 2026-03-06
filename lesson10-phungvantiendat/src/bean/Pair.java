package bean;

public class Pair {
	
	private int value;
	private int count;
	
	public Pair(int value, int count) {
		this.value = value;
		this.count = count;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public void plusCount() {
		this.count++;
	}
	
}
