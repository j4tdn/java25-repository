package view;

import java.io.File;
import java.io.FileFilter;

public class Ex05StringExercises {
	public static void main(String[] args) {
		String path = System.getProperty("user.home") + "/Desktop/music";
		File musicDir = new File(path);

		if (musicDir.exists() && musicDir.isDirectory()) {
			File[] mp3Files = musicDir.listFiles(new FileFilter() {
				@Override
				public boolean accept(File file) {
					return file.isFile() && file.getName().toLowerCase().endsWith(".mp3");
				}
			});

			if (mp3Files != null) {
				int i = 1;
				for (File file : mp3Files) {
					String filename = file.getName();
					System.out.println(i++ + ". " + filename.substring(0, filename.lastIndexOf(".")));
				}
			}
		}

	}

}
