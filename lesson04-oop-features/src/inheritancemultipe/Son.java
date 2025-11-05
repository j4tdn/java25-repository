package inheritancemultipe;


public class Son extends Father implements GrandFather, GrandMother {
	/**
	 Java không hỗ trợ đa thừa kế vì
	 - class extends class khác khôg bắt buộc phải override method
	 -vì không bắt buộc override dẫn đến nếu class extends 2/N class cha
	 và 2/N class cha có chung 1 hàm cùng phần khai báo(ko bắt buộc override)
	 đối tượng con ko biết sẽ sử dụng hàm từ class cha nào
	 */
	
	@Override
	public void gaming() {
		System.out.println("Son --> gaming ...");
		
	}
	
	@Override
	public void building() {
		System.out.println("Son --> building...");
		
	}


	
}
