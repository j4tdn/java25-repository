package view;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import bean.Candidate;

public class Ex01MissIT {
	
	private static Scanner ip;

	public static void main(String[] args) {
		ip = new Scanner(System.in);
		try {
			int numberOfJudges = ip.nextInt();
			if(numberOfJudges < 0) {
				throw new IllegalArgumentException("Ko có gk sao chấm");
			}
			
			ip.nextLine();
			
			Map<Integer, Candidate> candidateMap = new HashMap<Integer, Candidate>();
			for (int i = 0; i < numberOfJudges; i++) {
				String line = ip.nextLine().trim();
				String[] parts = line.split(" ");
				int numberOfChoices = Integer.parseInt(parts[0]);
				if(numberOfChoices < 1 || numberOfChoices > 3) {
					throw new IllegalArgumentException("Mỗi gk chỉ đc chấm tối đa 3 uv");
				}
				for (int rank = 1; rank <= numberOfChoices; rank++) {
					int candidateId = Integer.parseInt(parts[rank]);
					if (!candidateMap.containsKey(candidateId)) {
	                    candidateMap.put(candidateId, new Candidate(candidateId));
	                }
					Candidate currentCandidate = candidateMap.get(candidateId);
					currentCandidate.addScoreFromRank(rank);
				}
			}
			
			Comparator<Candidate> candidateComparator = (c1, c2) -> {
                if (c1.getTotalScore() != c2.getTotalScore()) {
                    return Integer.compare(c2.getTotalScore(), c1.getTotalScore()); 
                }
                if (c1.getCountRank1() != c2.getCountRank1()) {
                    return Integer.compare(c2.getCountRank1(), c1.getCountRank1()); 
                }
                if (c1.getCountRank2() != c2.getCountRank2()) {
                    return Integer.compare(c2.getCountRank2(), c1.getCountRank2()); 
                }
                return Integer.compare(c1.getId(), c2.getId()); 
            };
            
            List<Candidate> candidateList = candidateMap.values()
            		.stream().sorted(candidateComparator)
            		.toList();
            
            Candidate topCandidate = candidateList.get(0);
            
            String result = candidateList.stream()
                    .filter(c -> c.getTotalScore() == topCandidate.getTotalScore() 
                              && c.getCountRank1() == topCandidate.getCountRank1() 
                              && c.getCountRank2() == topCandidate.getCountRank2())
                    .map(c -> String.valueOf(c.getId()))
                    .collect(Collectors.joining(" "));

            System.out.println(result);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			ip.close();
		}
	}
	
}
