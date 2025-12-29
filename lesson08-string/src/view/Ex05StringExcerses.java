package view;

import java.io.File;
import java.io.FileFilter;

public class Ex05StringExcerses {

	public static void main(String[] args) {

	    /*
	     Viết chương trình in ra danh sách bài nhạc mp3 có trong thư mục music
	     Input:
	            String bh1 = d:/music/somethingyoulike.mp3
	            String bh2 = d:/music/foreverandone.mp3
	            String bh3 = d:/music/takemetoyourheart.mov
	            String[] arrStr = {bh1, bh2, bh3}
	     Output:
	     Danh sách bài hát mp3 trong thư mục d:/music gồm:
	            1. somethingyoulike
	            2. foreverandone
	     */

	    //String path = "C:\\Users\\qphan\\Desktop\\music";
		String path = "D:/music";
	    File musicDir = new File(path);

	    if (musicDir.exists()) {
	        File[] mp3Files = musicDir.listFiles(new FileFilter() {
				
				@Override
				public boolean accept(File file) {
					  return file.isFile() && file.getName().endsWith(".mp3");
				}
			}) ;
	        for (File file : mp3Files) {
	            String filename = file.getName();
	            System.out.println(filename.substring(0, filename.lastIndexOf(".")));
	        }
	    }
	}
}
