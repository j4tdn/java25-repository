package Bai2;

import shopping.ItemDetail;

public class Main {
	
	public static void main(String[] args) {

		Xe x1 = new Xe("Nguyễn Thu Loan","Future Neo", 100, 35000000);
		Xe x2 = new Xe("Lê Minh Tính","Ford Ranger",3000,250000000);
		Xe x3 = new Xe("Nguyễn Minh Triết","Landscape",1500, 1000000000);
		
		Xe[] dsXe = {x1,x2,x3};
		
		for(Xe xe : dsXe) {
			System.out.println("Chủ xe " + xe.getCustomer());
			System.out.println("Loại xe " + xe.getType());
			System.out.println("Dung Tích " + xe.getXilanh());
			System.out.printf("Giá Trị Xe %.0f\n",xe.getSaleprice());
			System.out.printf("Thuế Phải Nộp %.0f\n",xe.tinhthue());
			System.out.println("================================");
		}
		
		
	}
	
}
