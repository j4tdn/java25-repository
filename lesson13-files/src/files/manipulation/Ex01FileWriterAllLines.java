package files.manipulation;

import java.awt.Desktop;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import model.DataModel;

public class Ex01FileWriterAllLines {
	
	private static final String PATH = "lesson13-files/storage/template.txt";

	public static void main(String[] args) {
		Set<Entry<String, Integer>> models = DataModel.mockModelMap().entrySet();

		File file = new File(PATH);
		
		if(!file.exists()) {
			System.out.println("File " +file.getName()+" is not existed yet ...");
			return;
		}
		
		final List<String> lines = models.stream()
				.map(e -> e.getKey() +": "+e.getValue())
				.collect(Collectors.toList());
		
		lines.add(0, "=== Danh sách biển số xe theo thành phố tại Việt Nam ===");
		
		try {
			Files.write(file.toPath(), lines);
			Desktop.getDesktop().open(file);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}

}
