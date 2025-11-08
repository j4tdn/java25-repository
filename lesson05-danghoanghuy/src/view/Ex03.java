package view;

public class Ex03 {
	
	/*
		 	Bài 3 (20đ):Tìm số tự nhiên hợp lệ lớn nhất trong chuỗi. Biết rằng chuỗi chỉ gồm
		các ký tự số và chữ cái không dấu. Ví dụ
		▪ 12abu02muzk586cyx → 586
		▪ Uyk892nn1234uxo2 → 1234
		Method signature: int getMaxValidNumber(....)
	*/
	
	 public static void main(String[] args) {
		 
	     System.out.println(getMaxValidNumber("12abu02muzk586cyx"));
	     System.out.println(getMaxValidNumber("Uyk892nn1234uxo2"));
	    }
	
    public static int getMaxValidNumber(String s) {
        if (s == null) {
            return 0;
        }

        int maxNum = 0;
        String currentNumStr = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c >= '0' && c <= '9') {
                currentNumStr += c;
            } 
            else {
                if (currentNumStr.length() > 0) {
                    int num = Integer.parseInt(currentNumStr);
                    if (num > maxNum) {
                        maxNum = num;
                    }
                    currentNumStr = "";
                }
            }
        }
        
        if (currentNumStr.length() > 0) {
            int num = Integer.parseInt(currentNumStr);
            if (num > maxNum) {
                maxNum = num;
            }
        }

        return maxNum;
    }

}