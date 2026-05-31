package file.manipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

public class Ex02FileReader {
	private static final String PATH = "lesson13-files/storage/template.txt";
	public static void main(String[] args) {
		
		
		File file = new File(PATH);

		if (!file.exists()) {
			System.out.println("File " + file.getName() + " is not exitsed yet ...");
			return;
		}
		
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
