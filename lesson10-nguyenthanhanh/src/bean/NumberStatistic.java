package bean;

public class NumberStatistic {

	private int value;
	private int count;
	
	public NumberStatistic(int value) {
		this.value = value;
        this.count = 1;
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
	
	public void increment() {
        this.count++;
    }
	
}
