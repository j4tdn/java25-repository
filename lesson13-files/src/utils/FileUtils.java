package utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

	private FileUtils() {

	}

	public static void writeObjectAndOpen(String path, Object object) {
		File file = new File(path);

		if (!file.exists()) {
			System.out.println("File " + file.getName() + " is not existed yet ...");
			return;
		}

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(object);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(fos, oos);
		}

	}
	
	public static Object readObject(String path) {
		File file = new File(path);
		
		if(!file.exists()) {
			System.out.println("File " +file.getName()+" is not existed yet ...");
			return null;
		}
		
		FileInputStream fos = null;
		ObjectInputStream ois = null;
		
		try {
			fos = new FileInputStream(file);
			ois = new ObjectInputStream(fos);
			
			return ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(fos, ois);
		}
		
		return null;
	}

	// helper methods for manipulation
	public static void writeAndOpen(String path, Iterable<String> iterable) {
		File file = new File(path);

		if (!file.exists()) {
			System.out.println("File " + file.getName() + " is not existed yet ...");
			return;
		}

		try {
			Files.write(file.toPath(), iterable);
			Desktop.getDesktop().open(file);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public static List<String> read(String path) {
		List<String> lines = new ArrayList<>();
		File file = new File(path);

		if (!file.exists()) {
			System.out.println("File " + file.getName() + " is not existed yet ...");
			return lines;
		}

		try {
			lines = Files.readAllLines(file.toPath());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lines;
	}

	public static void close(AutoCloseable... closeables) {
		for (AutoCloseable closeable : closeables) {
			try {
				closeable.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static String getExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".")) + 1;
	}

	public static boolean upload(String sourcePath, String targetDir) {
		Path source = Path.of(sourcePath);
		Path target = Path.of(targetDir);

		try {
			Path targetDirPath = target.resolve(renameTo(source.getFileName()));
			Files.copy(source, targetDirPath, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("File " + target.getFileName() + " is updated Successfully");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Path renameTo(Path path) {
		String pathAsString = path.toString();
		String fileName = pathAsString.substring(0, pathAsString.lastIndexOf("."));
		String extension = pathAsString.substring(pathAsString.lastIndexOf("."));
		return Path.of("RN-" + fileName + "-" + System.currentTimeMillis() + extension);
	}

	public static boolean delete(String path) {
		File file = new File(path);
		if (!file.exists()) {
			System.err.println("File " + file.getName() + " not exist");
			return false;
		}
		file.delete();
		System.out.println("File " + file.getName() + " is deleted successful");
		return true;
	}

	public static boolean createFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			createDir(file.getParent());
			try {
				file.createNewFile();
				System.out.println("File " + file.getName() + " is created successfully");
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		System.out.println("File " + file.getName() + " is already exist");
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
