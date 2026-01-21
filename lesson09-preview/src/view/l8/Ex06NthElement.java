package view.l8;

public class Ex06NthElement {
	public static void main(String[] args) {

		int nthElement = 100;

		int runing = 1;

		StringBuilder sb = new StringBuilder();

		while (true) {
			sb.append(runing++);
			if (sb.length() >= nthElement) {
				break;
			}
		}

		System.out.println("sb --> " + sb);
		System.out.printf("Phan tu tai vi tri %s la '%s' ", nthElement, sb.charAt(nthElement - 1));

	}

}
