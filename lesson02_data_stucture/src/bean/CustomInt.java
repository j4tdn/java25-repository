package bean;
// KDL CustomInt
public class CustomInt {
	// Attribute
	public int value;
	
	// cosntructor
	public CustomInt(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "" + value;
	}

}
