package files.manipulation;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Set;

import model.DataModel;
import utils.FileUtils;

public class Ex01FileWriter {

	private static final String PATH = "lesson13-files/storage/template.txt";

	public static void main(String[] args) {
		System.out.println("=== Main Page starts ===");
		
		Set<Entry<String, Integer>> models = DataModel.mockModelMap().entrySet();
		
		File file = new File(PATH);

		if (!file.exists()) {
			System.out.println("File " + file.getName() + " is not existed yet ...");
			return;
		}

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			bw.write("=== Danh sách mã biển số xe theo thành phố tại Việt Nam ===");
			bw.newLine();
			
			for (Entry<String, Integer> model: models) {
				bw.write(model.getKey() + ": " + model.getValue());
				bw.newLine();
			}
			
			System.out.println("Opening file ....");
			Desktop.getDesktop().open(file);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(bw, fw);
		}
		
		System.out.println("=== Main Page ends ===");
	}

}
