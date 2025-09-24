package view;

import bean.Caradv;

public class Ex03StaticAttribute {
	public static void main(String[] args) {
		Caradv.setModel("Audi");
		Caradv c1 = new Caradv("Audi","Red");
		Caradv c2 = new Caradv("Audi","blue");
		Caradv c3 = new Caradv("Audi","white");
		Caradv c4 = new Caradv("Audi","black");
		Caradv c5 = new Caradv("Audi","pink");
		Caradv ck = new Caradv("Audi","green");
		
		
		
		//Nếu model là non static thì mỗi đối tượng sẽ quản lý riêng thuộc tính đối tượng đó 
		//đổi model của c2 thì chỉ ô nhớ của c2 bị thạy đổi còn lại giữ nguyên
		c2.setModel("MG");
		System.out.println("c1"+c1);
		System.out.println("c2"+c2);
		System.out.println("c3"+c3);		
		System.out.println("c4"+c4);
		System.out.println("c5"+c5);	
		System.out.println("ck"+ck);
		
		
	}
}
