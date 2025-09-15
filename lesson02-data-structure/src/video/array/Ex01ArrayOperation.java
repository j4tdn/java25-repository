package video.array;

//88826682444
public class Ex01ArrayOperation {
	public static void main(String[] args) {
		int[] numbers = new int[5];
		System.out.println("Number 3:" + numbers[3]);
		for (int num : numbers) {
			System.out.println("Num: " + num);

		}
		String[] sequences = { "Tài", "Lan", "Hoa", "Thương", "Thu" };
		String[] text = new String[3];
		int i = 0;
		for (String sequence : sequences) {
			System.out.println("Sequence: " + sequence);
			if (i < text.length) {
				text[i] = sequence;
				i++;

			}
			for (i = 0; i < text.length; i++) {
				System.out.println(text[i]);
			}

		}

	}
}
