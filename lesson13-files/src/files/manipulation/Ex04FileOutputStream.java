package files.manipulation;

import java.util.Map.Entry;
import java.util.Set;

import model.DataModel;
import utils.FileUtils;

public class Ex04FileOutputStream {
	
	private static final String PATH = "lesson13-files/storage/knowledge.txt";

	public static void main(String[] args) {
		Set<Entry<String, Integer>> models = DataModel.mockModelMap().entrySet();

		
		
//		final List<String> lines = models.stream()
//				.map(e -> e.getKey() +": "+e.getValue())
//				.collect(Collectors.toList());
		
		FileUtils.writeObjectAndOpen(PATH, DataModel.mockAppleList());
	}

}
