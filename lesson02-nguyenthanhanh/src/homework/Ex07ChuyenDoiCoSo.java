package homework;

public class Ex07ChuyenDoiCoSo {

	public static void main(String[] args) {
		
		System.out.println("Cơ số 10 --> Thập phân " + convert(10));
		System.out.println("Cơ số 8 --> Thập phân " + convert(8));
		System.out.println("Cơ số 6 --> Thập phân " + convert(6));
		
	}
	
	private static String convert(int decimal) {
		String binaryAsString = "";
		while(true) {
			int modPart = decimal%2;
			binaryAsString = binaryAsString + modPart;
			decimal /= 2;
			if(decimal == 0) {
				break;
			}
		}
			
		return binaryAsString;
	}
	
}
