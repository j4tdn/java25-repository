package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MissIT {
	
	    public static void main(String[] args) {
	        List<Integer> line1 = Arrays.asList(3,5,2,1);
	        List<Integer> line2 = Arrays.asList(3, 12,5,2);
	        List<Integer> line3 = Arrays.asList(2,1,2);
	        List<Integer> line4 = Arrays.asList(3,2,1,5);

	        List<List<Integer>> lines = new ArrayList<>();
	        lines.add(line1);
	        lines.add(line2);
	        lines.add(line3);
	        lines.add(line4);
	        System.out.println(lines);

	        Set<Integer> result = new HashSet<>(lines.get(0));

	        for (int i = 1; i < lines.size(); i++) {
	            result.retainAll(new HashSet<>(lines.get(i)));
	        }

	   
	        System.out.println(result);
	    }
	
}