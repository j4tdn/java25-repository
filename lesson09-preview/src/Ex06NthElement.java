public class Ex06NthElement {
	
	public static void main(String[] args) {
		
		int nthElement = 70; // Vị trí cần tìm
		
		int running = 1;
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			sb.append(running++);
			if (sb.length() >= nthElement) {
				break;
			}
		}
		
		System.out.println("sb --> " + sb);
		System.out.printf("Phần tử tại vị trí %s là số '%s'", nthElement, sb.charAt(nthElement-1));
		
	}
	
}