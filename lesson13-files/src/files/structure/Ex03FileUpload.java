package files.structure;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import utils.FileUtils;

public class Ex03FileUpload {
	
	public static void main(String[] args) {
		FileUtils.upload("lesson13-files/storage/Solution.jpg", "lesson13-files/target");
	}
	
}
