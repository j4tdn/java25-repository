package view;

import static utils.FileUtils.*;

import java.nio.file.Path;

public class Ex02 {
	private static final String PATH = "garbage/images";

	public static void main(String[] args) {
//		createFileBaseOnExtensionAndQuantity(30, "garbage/images", ".jpg");
//		createFileBaseOnExtensionAndQuantity(30, "garbage/images", ".png");
		
		renameFilesInDirectory(Path.of(PATH), "jpg");
		
	}
	
	
}
