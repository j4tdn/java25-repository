package exception;

public class ValidateNumber {

	public static String readNumber (int n) {
		
		if (n == 0) return "không";

        String[] digits = {"không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};
        String result = "";

        int hundreds = n / 100;
        int tens = (n % 100) / 10;
        int ones = n % 10;

        if (hundreds > 0) {
            result += digits[hundreds] + " trăm";
        }

        if (tens > 0) {
            if (hundreds > 0) result += " "; 
            if (tens == 1) {
                result += "mười";
            } else {
                result += digits[tens] + " mươi";
            }
        } else if (hundreds > 0 && ones > 0) {
            result += " lẻ";
        }

        if (ones > 0) {
            if (hundreds > 0 || tens > 0) result += " ";
            
            if (ones == 1 && tens > 1) {
                result += "mốt";
            } else if (ones == 5 && tens > 0) {
                result += "lăm";
            } else {
                result += digits[ones];
            }
        }

        return result;
    }
	
}
