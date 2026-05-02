package files.structure;

import static utils.FileUtils.createFile;

public class Ex01FileCreator {
	
	// Để thao tác với file, folder với Java
	
	// Sử dụng class [java.io.File] và [java.nio.file.Path] với 2 cách làm và có thể convert ép kiểu qua về
	
	public static void main(String[] args) {
		System.out.println("=== Main Page starts ===");
		
		createFile("lesson13-files/storage/knowledge.txt");
		
		System.out.println("=== Main Page ends ===");
		
	}
	
	
	
}
