package files.structure;


import utils.FileUtils;

public class Ex03FileUpload {
	
	public static void main(String[] args) {
		System.out.println("=== Main Page Starts ===");
		FileUtils.upload(
				"lesson13-files/storage/calendar.png",
				 "lesson13-files/target"
				);
		
		System.out.println("=== Main Page ends ===");
		}
}
