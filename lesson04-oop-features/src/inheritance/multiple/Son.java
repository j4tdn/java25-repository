package inheritance.multiple;


public class Son extends Father/*, Mother */ implements GrandFather, GrandMother{

	/*
	  java không hổ trợ đa thừa kế
	  - class extends class khác ko bắt buộc override method
	  - vì ko bắt buộc override dẫn đến nếu class extends 2/N class cha
	    và 2/N class cha có chung 1 hàm cùng phần khai báo(ko bắt buộc override)
	    đối tượng con ko biết sẽ sử dụng hàm từ class cha nào
	 */
	
	@Override
	public void buiding() {
		System.out.println("son --> building");
		
	}

	@Override
	public void gaming() {
		System.out.println("Son --> gaming");
		
	}
	
	
	
	


}
