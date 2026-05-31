package files.structure;

import static utils.FileUtils.*;

public class Ex02FileDelection {

	public static void main(String[] args) {
		
	System.out.println("=== Main Page ===\n");
		
		createFile("lesson13-files/trash/x1.txt");
		createFile("lesson13-files/trash/x2.txt");
		createFile("lesson13-files/trash/x3.txt");
		
		delete("lesson13-files/trash/x2.txt");
		
		System.out.println("\n=== Main Page ends ===");
		
	}
	
}
