import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Ex01MissIT {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; ++i) {
			int choose = sc.nextInt();
			for (int j = 0; j < choose; ++j) {
				int score = sc.nextInt();
				if (!map.containsKey(score)) {
					map.put(score, 1);
				} else {
					map.put(score, map.get(score) + 1);
				}
			}
		}

		List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

		list.sort((s1, s2) -> {
			if (s1.getValue() != s2.getValue()) {
				return s2.getValue() - s1.getValue();
			} else {
				return s1.getKey() - s2.getKey();
			}
		});
		
		int maxScore = list.get(0).getValue();
		int candidateId = list.get(0).getKey();
		
		List<Integer> results = new ArrayList<> ();

		for (var entry : list) {
			int score = entry.getValue();
			if(score >= maxScore) {
				maxScore = score;
				if(candidateId < entry.getKey()) {
					candidateId = entry.getKey();
				}
				results.add(candidateId);
			}
		}
		
		if(results.size() > 1) {
			System.out.println(results.subList(1, results.size()));
		}else {
			System.out.println(results.get(0));
		}

	}

}
