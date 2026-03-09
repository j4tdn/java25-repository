import java.util.*;

public class Bai4 {

	static boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {

		String[] arr = { "-2", "-6", "10", null, "4", "8", null, "Special", "a", "c", "b", "xx" };

		List<Integer> am = new ArrayList<>();
		List<Integer> duong = new ArrayList<>();
		List<String> chuoi = new ArrayList<>();
		int special = 0;
		int nullCount = 0;

		for (String s : arr) {

			if (s == null) {
				nullCount++;
			} else if (s.equalsIgnoreCase("Special")) {
				special++;
			} else if (isNumber(s)) {
				int n = Integer.parseInt(s);
				if (n < 0)
					am.add(n);
				else
					duong.add(n);
			} else {
				chuoi.add(s);
			}
		}

		Collections.sort(am);
		Collections.sort(duong);
		Collections.sort(chuoi);

		System.out.print("Tang dan: ");

		for (int i = 0; i < special; i++)
			System.out.print("Special, ");

		for (int x : am)
			System.out.print(x + ", ");

		for (int x : duong)
			System.out.print(x + ", ");

		for (String s : chuoi)
			System.out.print(s + ", ");

		for (int i = 0; i < nullCount; i++)
			System.out.print("null, ");

		System.out.println();

		Collections.reverse(am);
		Collections.reverse(duong);
		Collections.reverse(chuoi);

		System.out.print("Giam dan: ");

		for (int i = 0; i < nullCount; i++)
			System.out.print("null, ");

		for (String s : chuoi)
			System.out.print(s + ", ");

		for (int x : duong)
			System.out.print(x + ", ");

		for (int x : am)
			System.out.print(x + ", ");

		for (int i = 0; i < special; i++)
			System.out.print("Special, ");
	}
}