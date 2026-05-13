package files.structure;

import java.io.File;
import java.util.Arrays;

import static utils.FileUtils.*;

public class Ex04FileFilter {
	
	public static void main(String[] args) {
		File storage = new File("lesson13-files/storage");
		
		File[] txtFiles = storage.listFiles(file -> {
			String extension = getExt(file.getName());
			return file.isFile() && "txt".equals(extension);
		});
		
		Arrays.stream(txtFiles).forEach(System.out::println);
	}

}
