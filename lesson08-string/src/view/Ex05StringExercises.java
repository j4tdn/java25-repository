package view;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class Ex05StringExercises {
	public static void main(String[] args) {
		/*

		Viết chương trình in ra danh sách bài nhạc mp3 có trong thư mục music
		Input:

			String bh1 d:/music/somthingyoulike.mp3	
			String bh2 d:/music/foreoverandone.mp3	
			String bh3 d:/music/takemetoyourheart.mov
			String [] arrStr {bh1, bh2, bh3}

		Output:
		Danh sách bài hát mp3 trong thu muc d:/music gồm:
			1. somthingyoulike
			2. foreoverandone
		
		*/
		
		String path = "C:\\Users\\linh0\\OneDrive\\Máy tính\\music";
		File musicDir = new File(path);
		if(musicDir.exists()) {
			File[] mp3Files = musicDir.listFiles(new FileFilter() {
				
				@Override
				public boolean accept(File file) {
					return file.isFile() && file.getName().endsWith(".mp3");
				}
			});
			for(File file : mp3Files) {
				String filename = file.getName();
				System.out.println(file.getName());
				System.out.println(filename.substring(0, filename.lastIndexOf(".")));
			}
			
			
		}

		
	}
}
