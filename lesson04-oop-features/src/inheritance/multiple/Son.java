package inheritance.multiple;

public class Son extends Father/*, Mother */ implements GrandFather, GrandMother{
	/*
	  Java không hỗ trợ đa thừa kế vì
	  	-Class extend class khác không bắt buộc phải override method
	  	-Vì không bắt buộc override dẫn đến nếu class extend 2/N class cha
	  	và 2/N class cha có chung 1 hàm cùng khai báo (kh bắt buộc override)
	  	đối tượng con kh biết sẽ sd hàm từ class cha nào
	 */
	
	@Override
	public void gaming() {
		System.out.println("Son --> gaming...");
		
	}
	@Override
	public void building() {
		System.out.println("Son --> building");
		
	}
}
