package file.manipulation;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Map.Entry;
import java.util.Set;

import utils.FileUtils;
import model.DataModel;

public class Ex01FileWriter {

	private static final String PATH = "lesson13-files/storage/template.txt";

	public static void main(String[] args) {
		Set<Entry<String, Integer>> models = DataModel.mockModelMap().entrySet();

		File file = new File(PATH);

		if (!file.exists()) {
			System.out.println("File " + file.getName() + " is not exitsed yet ...");
			return;
		}
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			bw.write("=== Danh sach ma bien so xe theo thanh pho tai VN ===");
			bw.newLine();
			for (Entry<String, Integer> model : models) {
				bw.write(model.getKey() + ": " + model.getValue());
				bw.newLine();
			}
			System.out.println("Opening file... ");
			Desktop.getDesktop().open(file);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(bw, fw);
		}
		System.out.println("===   Main Page ends ===");
	}

}
