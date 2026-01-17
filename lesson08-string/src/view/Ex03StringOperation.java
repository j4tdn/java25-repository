package view;

public class Ex03StringOperation {

	public static void main(String[] args) {
		
		String s = "Grid";
		String s1 = "Layout";
		
		// 1. Tính chiều dài của chuỗi s
		System.out.println("chiều dài của chuỗi s --> " + s.length());
		
		// 2. Nối chuỗi s1 vào chuỗi s --> lưu kết quả vào chuỗi s
		s = s1 + s;
		System.out.println("chuỗi s --> " + s.length());
		
		// 3. Lấy một ký tự tại vị trí index(3) trong chuỗi s
		System.out.println("ký tự tại vị trí index(3) trong chuỗi s --> " + s.charAt(3));
		
		// 4. Duyệt từng kí tự sau đó in ra mỗi kí tự trong mỗi hàng
		for(int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
		
		// 5. Duyện và in ra từng từ trong chuỗi, biết rằng các từ cách nhau bởi khoảng trắng
		for(int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i) + "  ");
		}
		
		// 6. Tìm vị trí(chỉ số) xuất hiện đầu tiên, cuối cùng của kí tự 'a' trong chuỗi s
		int firstAIndex = -1;
		int lastAIndex = -1;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'a') {
				firstAIndex = i;
				break;
			}
		}
		for(int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) == 'a') {
				lastAIndex = i;
				break;
			}
		}
		System.out.println("\nvị trí(chỉ số) xuất hiện đầu tiên của kí tự 'a' --> " + firstAIndex);
		System.out.println("vị trí(chỉ số) xuất hiện cuối cùng của kí tự 'a' --> " + lastAIndex);
		
	}
	
}
