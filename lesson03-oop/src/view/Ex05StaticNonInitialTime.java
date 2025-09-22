package view;

public class Ex05StaticNonInitialTime {
	public static void main(String[] args) {
		
	}
	
	// Vi du voi 2 ham static
	private static void s1() {
		s2();
		// ns2(); tu ham static k the goi truc tiep ham non static vi chua co doi tuong nao de goi ham static
		Ex05StaticNonInitialTime o1 = new Ex05StaticNonInitialTime();
		o1.ns2();
	}
	
	private static void s2() {
			
	}
	
	// Ham, tt static dc khoi tao cung thoi diem thuc thi class
	
	// Ham, tt non static chi dc khoi tao khi tao ra doi tuong tu class do (sau)

	
	// Vi du voi 2 ham non static
	private void ns1() {
		ns2();
		s2(); // tu ham non static co the goi truc tiep ham static
				// vi ham static k phu thuoc doi tuong dang goi va dc khoi tao cung thoi diem voi class
	}
	
	private void ns2() {
		
	}
	
}
