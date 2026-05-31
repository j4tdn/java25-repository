package files.structure;

import static utils.FileUtils.*;

public class Ex02FileDeletion {
	
	public static void main(String[] args) {
		System.out.println("=== Main Page Starts ===");
		createFile("lesson13-files/trash/x1.txt");
		createFile("lesson13-files/trash/x2.txt");
		createFile("lesson13-files/trash/x3.txt");
		
		delete("lesson13-files/trash/x2.txt");
		
		System.out.println("=== Main Page ends ===");
	}

}
