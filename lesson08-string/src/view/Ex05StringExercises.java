package view;

import java.io.File;
import java.io.FileFilter;

public class Ex05StringExercises {
	public static void main(String[] args) {
		
		String path = "C:\\Users\\m2401024\\Desktop\\music";
		File muSicDir = new File(path);
		if (muSicDir.exists()) {
			File[] mp3Files = muSicDir.listFiles(new FileFilter() {
				
				@Override
				public boolean accept(File file) {
					return file.isFile() && file.getName().endsWith("mp3");
			}
		});
			for (File file : mp3Files) {
				String filename = file.getName();
				System.out.println(filename.substring(0, filename.lastIndexOf(".")));
			}
	}
	}

}
