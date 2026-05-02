package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileUtils {

	private FileUtils() {
	}
	
	public static void close(AutoCloseable ...closeables) {
		for (AutoCloseable closeable: closeables) {
			try {
				closeable.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean upload(String sourcePath, String targetDirPath) {
		Path source = Path.of(sourcePath);
		Path targetDir = Path.of(targetDirPath);
		
		try {
			Path target = targetDir.resolve(renameTo(source.getFileName()));
			Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("File " + target.getFileName() + " is uploaded successful.");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static String getExt(String filename) {
		return filename.substring(filename.lastIndexOf(".") + 1);
	}
	
	public static Path renameTo(Path path) {
		String pathAsString = path.toString();
		String filename = pathAsString.substring(0, pathAsString.lastIndexOf("."));
		String extension = getExt(pathAsString);
		return Path.of("RN-" + filename + "-" + System.currentTimeMillis() + "." + extension);
	}
	
	public static boolean delete(String path) {
		File file = new File(path);
		if (!file.exists()) {
			System.err.println("File " + file.getName() + " is not existing for delete.");
			return false;
		}
		file.delete();
		System.out.println("File " + file.getName() + " is deleted successful.");
		return true;
	}

	public static boolean createFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			createDir(file.getParent());
			try {
				file.createNewFile();
				System.out.println("File " + file.getName() + " is created successful.");
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		System.err.println("File " + file.getName() + " is existed already.");
		return false;
	}

	public static boolean createDir(String path) {
		File dir = new File(path);
		if (!dir.isDirectory()) {
			dir.mkdirs();
			System.out.println("Folder " + dir.getPath() + " is created successful.");
			return true;
		}
		return false;
	}

}
