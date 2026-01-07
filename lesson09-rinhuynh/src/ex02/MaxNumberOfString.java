package ex02;


public class MaxNumberOfString {
	public static void main(String[] args) {
		
		
		String s1 = "01a2b3456cde478";
		String s2 = "aa6b546c6e22h";
		
		String[] ss1 = getLargestNumbers(s1, s2);
		printResult("Result: ", ss1);
		
		
	}
	
	private static String[] getLargestNumbers(String... ss) {
		String[] result = new String[ss.length];
		for (int i = 0; i < ss.length; i++) {
			String[] nums = ss[i].split("[a-z]+");
			
			int max = Integer.MIN_VALUE;
			
			for (String n : nums) {
				if (!n.isEmpty()) {
					max = Math.max(max,  Integer.parseInt(n));
				}
			}
			result[i] = String.valueOf(max);
		}
		
		return result;
	}
	
	private static void printResult(String text, String[] result) {
		System.out.println(text);
		for (int i = 0; i < result.length; i++) {
			System.out.println("- String " + (i+1) + ":" + result[i]);
		}
	}

}
