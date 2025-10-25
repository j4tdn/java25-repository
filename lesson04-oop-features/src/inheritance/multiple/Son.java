package inheritance.multiple;

public class Son extends Father implements GrandFather, GrandMother {
		
		/*
		Java k hỗ trợ đa thừa kế vì
		  - class ễtnds class khác k bắt buộc phải override method
		  - vì k bắt buộc override dân đến nếu class extends 2/N class cha
		    và 2/N class cha có chung 1 hà cùng phần khai báo(k bắt buộc override)
		    đối tươngj con k biết sẽ sd hàm từ class cha nào 
		 */
	@Override
	public void gaming() {
		System.out.println("Son --> gaming ...");
	}
	
	@Override
	public void building() {
		System.out.println("Son --> gaming ...");
	}

}
