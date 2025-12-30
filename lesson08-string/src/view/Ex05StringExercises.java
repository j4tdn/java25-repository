package view;

import java.io.File;
import java.io.FileFilter;

public class Ex05StringExercises {

	public static void main(String[] args) {
		String path = "C:\\Users\\Admin\\Music";
		File musicDir = new File(path);
		if(musicDir.exists()) {
			File[] mp3Files = musicDir.listFiles(new FileFilter() {
				
				@Override
				public boolean accept(File file) {
					return file.isFile() && file.getName().endsWith(".mp3");
				}
			});
			
			for(File file: mp3Files) {
				String fileName = file.getName();
				System.out.println(fileName.substring(0,fileName.lastIndexOf(".")));
			}
		}

	}
	
}
