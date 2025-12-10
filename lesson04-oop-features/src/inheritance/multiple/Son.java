package inheritance.multiple;

public class Son extends Father implements GrandFather, GrandMother {
	
	/*
	 
	 java không hỗ trợ đa thừa kế vì
	 - class extends class khác không bắt buộc phải override method
	 - vì không bắt buộc phải override dẫn đến nếu class extends 2/N class cha
	 và 2/N class cha có chung 1 hàm cùng phần khai báo (k bắt buộc phải override)
	 đối tượng con không biết sẽ sử dụng hàm từ class cha nào
	 
	 */
	@Override
	public void building() {
		System.out.println("son --> gaming...");
	}
	@Override
	public void gaming() {
		System.out.println("son --> gamming...");
	}

}
