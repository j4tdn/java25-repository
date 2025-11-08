package ex03;

public class GetMaxValidNumber {

	public static void main(String[] args) {

		
		String s1 = "12abu02muzk586cyx";
		System.out.println(getMaxValidNumber(s1));
	}

	public static int getMaxValidNumber(String a) {
		
		int max = -1;
		String num = "";
		
		for (int i = 0; i < a.length();i++) {
			char c = a.charAt(i);
		
		if(Character.isDigit(c)) {
			num = num + c;
		}else {
			if(!num.isEmpty()) {
				int value = Integer.parseInt(num);
				if(value > max) {
					max = value;
					num = "";
				}
			}
		}
		
		if(!num.isEmpty()) {
			int value = Integer.parseInt(num);
			if(value > max) {
				max = value;
		}
		}		
		}
		return max;
		
	}
	
}
