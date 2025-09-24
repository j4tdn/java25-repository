package view;

public class Ex05StaticNonInitialTime {

	public static void main(String[] args) {
		s1();
		s2();
		
		

	}
	
	// Ham, thuoc tinh static duoc khoi tao cung thoi diem thuc thi class (truoc)

	// Ham, thuoc tinh non-static chi duoc khoi tao khi tao ra doi tuong tu class do (sau)
	

	private static void s1() {
		s2();
		
		// ns2() tu ham static ko the truc tiep goi ham non-static vi chua co doi tuong nao de goi ham static
	}
	
	private static void s2() {
		
	}
	
	private void ns1() {
		ns2();
		s2(); // tu ham non-static co the goi truc tiep ham static.
			// vi ham static khong phu thuoc doi tuong dang goi va duoc khoi tao cung thoi diem voi class
	}
	
	private void ns2() {
		
	}

}
