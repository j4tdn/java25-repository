package files.manipulation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Map.Entry;
import java.util.Set;

import utils.FileUtils;

import static utils.FileUtils.*;

public class Ex01FileWriter {
	
	private static final String PATH = "lesson13-files/storage/template.txt";

	public static void main(String[] args) {
//		Set<Entry<String, Integer>> models = 

		File file = new File(PATH);
		
		if(!file.exists()) {
			System.out.println("File " +file.getName()+" is not existed yet ...");
			return;
		}
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
				bw.write("Xin chao");
				bw.newLine();
				bw.write("Xin chao 123");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(bw, fw);
		}
		
	}

}
