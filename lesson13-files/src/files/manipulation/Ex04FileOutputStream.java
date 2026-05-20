package files.manipulation;

import model.DataModel;
import utils.FileUtils;

public class Ex04FileOutputStream {

	private static final String PATH = "lesson13-files/storage/knowledge.txt";

	public static void main(String[] args) {
		System.out.println("=== Main Page starts ===");
		
		/*
		Set<Entry<String, Integer>> models = DataModel.mockModelMap().entrySet();
		
		List<String> lines = models.stream()
				.map(e -> e.getKey() + ": " + e.getValue())
				.collect(Collectors.toList());
		
		lines.add(0, "=== Danh sách mã biển số xe theo thành phố tại Việt Nam [06.05.2026] ===");
		
		FileUtils.writeObjectAndOpen(PATH, lines);
		*/
		
		FileUtils.writeObjectAndOpen(PATH, DataModel.mockAppleList());
		
		System.out.println("=== Main Page ends ===");
	}

}