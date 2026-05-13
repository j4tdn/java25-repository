package files.manipulation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import utils.FileUtils;

public class Ex03ValidNumber {
	
	private static final String PATH = "data/storage/example/d3input.txt";

	public static void main(String[] args) {
		List<String> lines = FileUtils.read(PATH);
		
		List<Long> nums = new ArrayList<Long>();
		
		for(int i = 1;i<lines.size();++i) {
			nums.add(getMaximumNumber(lines.get(i)));
		}
		
		nums.sort(Comparator.naturalOrder());
		
//		List<String> results = nums.stream().map(null)
//		nums.forEach(System.out::println);
//		
		
		FileUtils.writeAndOpen(PATH, lines);
	}
	
	private static long getMaximumNumber(String s) {
		for(char c : s.toCharArray()) {
			if(Character.isAlphabetic(c)) {
				s = s.replace(c, ' ');
			}
		}
		
		String[] arr = s.trim().split("\\s+");
		long result = Long.MIN_VALUE;
		for(String digit: arr) {
			result = Math.max(result, Long.parseLong(digit));
		}
		return result;
	}

}
