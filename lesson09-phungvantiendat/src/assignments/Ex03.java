package assignments;

public class Ex03 {
	public static void main(String[] args) {
		String s = "Welcome to JAVA10 class";
		String []arr = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<arr.length;++i) {
			sb.append(revert(arr[i])).append(" ");
		}
		System.out.println(sb);
	}
	
	private static String revert(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = s.length() - 1;i>=0;--i) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
}
