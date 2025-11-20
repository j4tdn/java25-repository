package test01;

public class Ex03ValidNumber {
	
	public static void main(String[] args) {
		
		String[] seqs = {"12abu02muzk586cyx", "Uyk892nn1234uxo2", "abcdef", "12345"};
		
		for (String seq: seqs) {
			System.out.println(seq + " has max number = " + getMaxValidNumber(seq));
		}
		
	}
	
	private static Integer getMaxValidNumber(String s) {
		if (s == null || s.isBlank()) {
			return null;
		}
		
		String[] elements = s.split("[a-zA-Z]+");
		
		if (elements.length == 0) {
			return null;
		}
		
		int max = Integer.MIN_VALUE;
		
		for (String element: elements) {
			if (element.isEmpty()) {
				continue;
			}
			max = Math.max(max, Integer.parseInt(element));
		}
		return max;
	}
	
}
