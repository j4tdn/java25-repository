package view;

public class Ex03Revert {

	public static void main(String[] args) {
		System.out.println("Chuỗi sau khi đảo ngược -->" 
				+ revert("Welcome to JAVA10 class"));
	}
	
	private static String revert(String str) {
		StringBuilder revertedPart = new StringBuilder();
		StringBuilder result = new StringBuilder();
		String[] parts = str.split(" ");
		for(String part : parts) {
			if(part.isEmpty()) {
				continue;
			}
			for(int i = part.length() - 1; i >= 0; i--) {
				revertedPart.append(part.charAt(i));
			}
			result.append(revertedPart + " ");
			revertedPart.setLength(0);
		}
		return result.toString();
	}
	
}