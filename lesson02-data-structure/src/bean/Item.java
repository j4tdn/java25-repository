package bean;

// Tao ra KDL ten Item (KDL doi tuong)

public class Item {
	// Cac thuoc tinh Item
	public int id;
	public char name;
	public double salesPrice;
	
	// KDL Item co 3 thuoc tinh: id, name, price
	// Khi tao ra 1 bien la KDL Item --> bien do se luu tru 3 thong tin: id, name, salesPrice
	
	// Ham khoi tao mac dinh (co san cho moi class neu chua ton tai)
	public Item() {
	}
	// Ham khoi tao voi cac tham so truyen vao
	public Item(int pid, char pname, double pSalesPrice) {
		this.id = pid;
		this.name = pname;
		this.salesPrice = pSalesPrice;
	}
	
	// Khi in 1 bien la KDL doi tuong
	// Thay vi de tu dong goi ham toString mac dinh cua class Object
	// --> Dinh nghia lai ham toString cho cac class de in ra du lieu phu hop
	
	// i1 --> i1.toString
	// i2 --> i2.toString
	public String toString() {
		return this.id + ", " + this.name + ", " + this.salesPrice;
	}
}
