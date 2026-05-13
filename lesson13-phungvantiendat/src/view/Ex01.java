package view;

import static utils.FileUtils.copy;
import static utils.FileUtils.createFileBaseOnExtensionAndQuantity;
import static utils.FileUtils.delete;
import static utils.FileUtils.handleWithFiles;
import static utils.FileUtils.move;

import java.nio.file.Path;

public class Ex01 {
	private static final String PATH = "garbage";

	public static void main(String[] args) {

		createFileBaseOnExtensionAndQuantity(20, "garbage", ".png");
		createFileBaseOnExtensionAndQuantity(20, "garbage", ".jpg");
		createFileBaseOnExtensionAndQuantity(20, "garbage", ".jpeg");
		createFileBaseOnExtensionAndQuantity(20, "garbage", ".mp3");
		createFileBaseOnExtensionAndQuantity(20, "garbage", ".mp4");
		createFileBaseOnExtensionAndQuantity(20, "garbage", ".bat");
		createFileBaseOnExtensionAndQuantity(20, "garbage", ".java");
		createFileBaseOnExtensionAndQuantity(20, "garbage", ".txt");

		handleWithFiles(Path.of(PATH), item -> move(item, "garbage/music"), "mp3", "mp4");
		handleWithFiles(Path.of(PATH), item -> move(item, "garbage/system"), "bat");

		handleWithFiles(Path.of(PATH), item -> delete(item), "txt");

		handleWithFiles(Path.of(PATH), item -> copy(item, Path.of("garbage/coding")), "java");

//		File file = new File(PATH);
//		File[] files = file.listFiles();
//		if(files != null) {
//			for (File item : files) {
//		        if (item.isFile()) {
//		            System.out.println(item.getName());
//		        }
//		    }
//		}
	}

}
