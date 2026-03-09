import java.util.*;

public class Ex04StringSort {

	public static void main(String[] args) {

		String[] strings = { "-2", "-6", "10", null, "4", "8", null, "Special", "a", "c", "b", "xx" };

		List<Integer> negative = new ArrayList<>();
		List<Integer> positive = new ArrayList<>();
		List<String> words = new ArrayList<>();

		int specialCount = 0;
		int nullCount = 0;

		for (String s : strings) {

			if (s == null) {
				nullCount++;
			} else if (s.equals("Special")) {
				specialCount++;
			} else {
				try {
					int num = Integer.parseInt(s);

					if (num < 0)
						negative.add(num);
					else
						positive.add(num);

				} catch (Exception e) {
					words.add(s);
				}
			}
		}

		Collections.sort(negative);
		Collections.sort(positive);
		Collections.sort(words);

		System.out.print("Tăng dần: ");

		for (int i = 0; i < specialCount; i++)
			System.out.print("Special, ");

		for (int n : negative)
			System.out.print(n + ", ");

		for (int n : positive)
			System.out.print(n + ", ");

		for (String w : words)
			System.out.print(w + ", ");

		for (int i = 0; i < nullCount; i++)
			System.out.print("null, ");

		System.out.println();

		System.out.print("Giảm dần: ");

		for (int i = 0; i < nullCount; i++)
			System.out.print("null, ");

		Collections.reverse(words);
		for (String w : words)
			System.out.print(w + ", ");

		Collections.reverse(positive);
		for (int n : positive)
			System.out.print(n + ", ");

		Collections.reverse(negative);
		for (int n : negative)
			System.out.print(n + ", ");

		for (int i = 0; i < specialCount; i++)
			System.out.print("Special, ");
	}
}