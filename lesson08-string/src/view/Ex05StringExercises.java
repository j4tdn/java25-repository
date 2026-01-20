package view;

import java.io.File;
import java.io.FileFilter;

public class Ex05StringExercises {

	public static void main(String[] args) {
		
		String path = "C:\\Users\\dangh\\OneDrive\\Máy tính\\music";
		File musicDir = new File(path);
		if(musicDir.exists()){
			File[] files = musicDir.listFiles(new FileFilter() {
				
				@Override
				public boolean accept(File file) {
					return file.isFile() && file.getName().endsWith("mp3");
				}
			});
			
			for(File file: files) {
				String filename = file.getName();
				System.out.println(filename.substring(0, filename.lastIndexOf(".")));
			}
		}
		
	}
	
}
