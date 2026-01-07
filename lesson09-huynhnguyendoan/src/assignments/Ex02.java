package assignments;

import java.util.Arrays;

public class Ex02 {
public static void main(String[] args) {
	String[] r1 = utils.StringExtractor.GetNumbers("01a2b3456cde478");
	String[] r2 = utils.StringExtractor.GetNumbers("aa6b546c6e2hh");
	System.out.println(Arrays.toString(r1));
	System.out.println(Arrays.toString(r2));
}
}
