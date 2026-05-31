package files.structure;

import java.io.File;
import java.util.Arrays;

import utils.FileUtils;

public class Ex04FileFilter {

	public static void main(String[] args) {
		
		File storage = new File("lesson13-files/storage");
		
		File[] txtFile = storage.listFiles(file -> {
			String extension = FileUtils.getExt(file.getName());
			return file.isFile() && "txt".equals(extension);
		});
		
		Arrays.stream(txtFile).forEach(System.out::println);
		
	}
	
}
