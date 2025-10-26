package inheritance.multiple;

public class Son extends Father implements GrandFather,GrandMother {
	/*
	 * Java khoong ho trợ đã thừa kế vì 
	 * -Class extend class khác không bắt buộc ohai override method 
	 * - Vì không bắt buộc override dẫn đến nếu calss extend 2/n class chavà 2/n classs cha có chung 1 hàm cùng pohaanf khai báo (khong bắt buộc ovriddedố tưoknjg con không biếtsẽ sử dụng  hàm từclass cha nào 
	 */
	@Override
	public void gaming() {
		// TODO Auto-generated method stub
		System.out.println("Son --> gaming ...");
	}
	@Override
	public void building() {
		// TODO Auto-generated method stub
		System.out.println("Son --> building ...");
	}
}
