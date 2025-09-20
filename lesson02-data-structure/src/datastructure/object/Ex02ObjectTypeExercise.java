package datastructure.object;

public class Ex02ObjectTypeExercise {
	/* Tồn tại các KDL có sẵn như: Integer, Double, Float, BigDecimai - String, Character - Boolean ...
	 * - Là 1 class có sẵn: chỉ có duy nhất một thuộc tính (hằng số)
	 * 					: ngoài việc lưu trữ, hỗ trợ các hàm để xử lý
	 * - Hỗ trợ giá trị NULL để lưu trữ các dữ liệu không bắt buộc
	 * - 
	 *  
	 */
	
	public static void main(String[] args) {
		// KDL nguyên thủy
		int a1 = 5;
		char a2 = 2;
		System.out.println("a1(%s) a2(%s)", a1, a2);
		
		System.out.println(\n);
		
		// Khai báo
		Integer b1 = new Integer(7);
		String b2 = new String("XinChao");
		
		System.out.println("b1(%s) b2(%s)", b1, b2);
		
		System.out.println(\n);
	}
}
