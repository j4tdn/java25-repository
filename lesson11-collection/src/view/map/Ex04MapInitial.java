package view.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static utils.PrintUtils.*;

public class Ex04MapInitial {

	public static void main(String[] args) {
		 Map<String, Integer> models = new LinkedHashMap<>();
	        models.put("Quảng Nam", 92);
	        models.put("Đà Nẵng", 43);
	        models.put("Huế", 75);
	        models.put("Quảng Trị", 74);
	        models.put("Quảng Bình", 73);
	        generate("1. models", models);
	        
	        Map<String, Integer> textLengthMap = new HashMap<String, Integer>() {
	        	{	put("AA",2);
	        		put("ABCD",4);
	        	}
	        };
	        textLengthMap.put("X12QA",  5);
	        generate("2. Number elements", textLengthMap);
	        
	        Map<Integer, String> numberToTextMap = Map.of(
	        		1,"one",
	        		2,"two",
	        		3,"three"
	        		);
	        generate("3. Number elemets", numberToTextMap);
	        
	  
	}
}
