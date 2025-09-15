package datastructure.object;

public class store {
	char name;
	int mocua;
	int dongcua;
	public store(char name, int mocua, int dongcua) {
		super();
		this.name = name;
		this.mocua = mocua;
		this.dongcua = dongcua;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name+","+this.dongcua +","+this.mocua;
	}

}
