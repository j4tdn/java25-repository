//Bài 3 (20đ):Tìm số tự nhiên hợp lệ lớn nhất trong chuỗi. Biết rằng chuỗi chỉ gồm
//các ký tự số và chữ cái không dấu. Ví dụ
//▪ 12abu02muzk586cyx → 586
//▪ Uyk892nn1234uxo2 → 1234
//Method signature: int getMaxValidNumber(....)
public class Ex03 {
	public static void main(String[] args) {
		System.out.println(getMaxValidNumber("12abu02444muzk586cyx"));
	}

	public static int getMaxValidNumber(String s) {
		int max = Integer.MIN_VALUE;
		String arrNum = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				arrNum += c;
			} else {
				if (!arrNum.equals("")) {
					int num = Integer.parseInt(arrNum);
					if (num > max)
						max = num;
					arrNum = "";
				}
			}
		}
		return max;
	}
}
