package files.manipulation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import model.DataModel;
import utils.FileUtils;

public class Ex04FileOutputStream {
	private static final String PATH = "lesson13-files/storage/knowledge.txt";

	public static void main(String[] args) {
		System.out.println(" === Main Page starts === ");
		Set<Entry<String, Integer>> models = DataModel.mockModelMap().entrySet();
		List<String> lines = models.stream().map(e -> e.getkey() + ": " + e.getValue()).collect(Collectors.toList());
		lines.add(0, " === Danh sach ma bien so xe theo thanh pho tai Viet Nam [06.05.2026] === ");
		File file = new File(PATH);
		if (!file.exists()) {
			System.out.println("File " + file.getName() + " is not existed yet ... ");
			return;
		}

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(lines);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(oos, fos);
		}
		
	}
}