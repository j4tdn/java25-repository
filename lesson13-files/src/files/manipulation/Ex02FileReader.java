package files.manipulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ex02FileReader {

	private static final String PATH = "lesson13-files/storage/template.txt";

	public static void main(String[] args) {
		System.out.println("=== Main Page starts ===");
		
		File file = new File(PATH);

		if (!file.exists()) {
			System.out.println("File " + file.getName() + " is not existed yet ...");
			return;
		}

		FileReader fr = null;
		BufferedReader br = null;

		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("=== Main Page ends ===");
	}
}