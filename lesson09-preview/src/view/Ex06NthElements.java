package view;

public class Ex06NthElements {

	public static void main(String[] args) {
		
		int running = 1;
		int nthElements = 100;
		StringBuilder sb = new StringBuilder();
		while (true) {
			sb.append(running++);
			if(sb.length() >= nthElements) {
				break;
			}
		}
		
		System.out.println("sb--> " + sb);
		System.out.printf("Phan tu tai vi tri %s la so %s ", nthElements, sb.charAt(nthElements - 2));
		
	}
	
}
