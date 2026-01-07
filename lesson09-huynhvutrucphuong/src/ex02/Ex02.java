package ex02;

public class Ex02 {
	public static String[] getLargestNumbers(String ...ss) {
		String[] res = new String[ss.length];
		for(int i=0;i< ss.length;i++) {
			String s = ss[i];
			String num = "";
			long max = 0;
			
			
			for(int  j=0;j<s.length();j++) {
				char c= s.charAt(j);
				if(c>='0' && c<='9') {
					num += c;
					
				}else {
					if(!num.equals("")) {
						long value = Long.parseLong(num);
						if(value > max) {
							max = value;
						}
						num = "";
					}
				}
			}
			if(!num.equals("")) {
				long value = Long.parseLong(num);
				if(value > max) {
					max = value;
				}
			}
			res[i] = String.valueOf(max);
		}
		
		
		return res;
		
	}
	public static void main(String[] args) {
		String[] result = getLargestNumbers(
				"aa6b546c6e22h",
				"aa6b326c6e22h");
		
		for(String s : result) {
			System.out.println(s +" ");
		}
	}
}
