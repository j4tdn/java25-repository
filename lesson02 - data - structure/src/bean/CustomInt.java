package bean;

//KDL CustomInt
public class CustomInt {

	
	//Attribute
	public int value;
	
	//Constructor
	public CustomInt(int value) {
		this.value =value;
	}
	
	@Override
	public String toString() {
		
		return ""+value;
	}
	
}
