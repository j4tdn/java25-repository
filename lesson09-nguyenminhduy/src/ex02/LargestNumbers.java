package ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestNumbers {
	public static String[] getLargestNumbers(String[] ss) {
		List<Integer> list = new ArrayList<>();
		for(String s: ss) {
			int max = 0;
			String num = "";
			for(char c : s.toCharArray()) {
				if(Character.isDigit(c)) {
					num += c;
				}else {
					if(!num.isEmpty()) {
						int val = Integer.parseInt(num);
						if(val > max) max = val;
						num = "";
					}
				}
			}
			if(!num.isEmpty()) {
				int val = Integer.parseInt(num);
				if(val > max) max = val;
			}
			list.add(max);
		}
		Collections.sort(list);
		String[] result = new String[list.size()];
		for(int i=0; i<list.size(); i++) {
			result[i] = String.valueOf(list.get(i));
		}
		return result;
	}
	
	public static void main(String[] args) {
		String[] res1 = getLargestNumbers(new String[] {"01a2b3456cde478"});
		String[] res2 = getLargestNumbers(new String[] {"aa6b546c6e22h","aa6b326c6e22h"});
		
		System.out.println(Arrays.toString(res1));
		System.out.println(Arrays.toString(res2));
	}

}
