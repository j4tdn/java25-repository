package view.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static util.PrintUtils.*;

public class Ex04MapInitial {

	public static void main(String[] args) {
		
		Map<String, Integer> models = new LinkedHashMap<>();

		models.put("Quang Nam", 92);
		models.put("Da Nang", 43);
		models.put("Hue", 75);
		models.put("Quang Tri", 74);
		models.put("Quang Binh", 73);
		generate("1. Models", models);
		
		Map<String, Integer> textLengthMap = new HashMap<String, Integer>(){
			private static final long serialVersionUID = 1L;
			{
				put("AA", 2);
				put("ABCD", 4);
			}
		};
		textLengthMap.put("X12QA", 5);
		generate("2. Text Length Elements", textLengthMap);
		
		Map<Integer, String> numberToTextMap = Map.of(
				1, "one", 
				2, "two", 
				3, "three");
		generate("3. Number Elements", numberToTextMap);
	}
	
}
