package utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class FileUtils {

	private FileUtils() {

	}
	
	public static void writeAndOpen(String path, Iterable<String> iterable) {
		File file = new File(path);
		
		if(!file.exists()) {
			System.out.println("File " + file.getName() + " is not existed yet ...");
			return;
		}
		
		try {
			Files.write(file.toPath(), iterable);
			Desktop.getDesktop().open(file);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static List<String> read(String path) {
		List<String> lines = new ArrayList<>();
		File file = new File(path);
		
		if(!file.exists()) {
			System.out.printf("File %s is not exist!\n", file.getName());
			return lines;
		}
		
		try {
			lines = Files.readAllLines(file.toPath());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return lines;
	}

	public static void handleWithFiles(Path path, Consumer<Path> func, String... ext) {
		try (Stream<Path> paths = Files.list(path)) {
			paths.filter(item -> filterBaseOnExt(item, ext))
			.forEach(func);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void renameFilesInDirectory(Path dir, String ext) {
		try(Stream<Path> paths = Files.list(dir)) {
			Path[] files = paths.filter(p -> filterBaseOnExt(p, ext))
					.sorted()
					.toArray(Path[]::new);
			
			for(int i = 0;i<files.length;++i) {
				renameTo(files[i], ""+(i+1));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	private static boolean filterBaseOnExt(Path path, String... ext) {
		if (!Files.isRegularFile(path)) {
			return false;
		}
		String fileName = null;
		for (String item : ext) {
			fileName = path.getFileName().toString().toLowerCase();
			if (fileName.endsWith("." + item)) {
				return true;
			}
		}
		return false;
	}

	public static void createFileBaseOnExtensionAndQuantity(int quantity, String path, String extension) {
		for (int i = 1; i <= quantity; ++i) {
			try {
				Thread.sleep(1000);
				String fileName = String.valueOf(System.currentTimeMillis());
				createFile(path, fileName, extension);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void copy(String source, String target) {
		Path srcDir = Path.of(source);
		Path targetDir = Path.of(target);
		try {
			Files.copy(srcDir, targetDir, StandardCopyOption.REPLACE_EXISTING);
			System.out.printf("File %s was copied successfully! ", srcDir.getFileName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void copy(Path source, Path target) {
		Path targetDir = target.resolve(source.getFileName());
		try {
			Files.copy(source, targetDir, StandardCopyOption.REPLACE_EXISTING);
			System.out.printf("File %s was copied successfully! \n", source.getFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void move(String source, String destination) {
		Path src = Path.of(source);
		Path target = Path.of(destination);

		try {
			Files.move(src, target, StandardCopyOption.REPLACE_EXISTING);
			System.out.printf("File %s was copied successfully! ", src.getFileName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void move(Path source, String destination) {
		Path target = Path.of(destination);
		try {
			Path targetDirPath = target.resolve(source.getFileName());
			Files.move(source, targetDirPath, StandardCopyOption.REPLACE_EXISTING);
			System.out.printf("File %s was copied successfully!\n", source.getFileName());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		return fileName.substring(fileName.lastIndexOf(".") + 1);
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

	public static boolean delete(Path path) {
		try {
			if (Files.deleteIfExists(path)) {
				System.out.println("File " + path.getFileName() + " is deleted successful");
				return true;
			}
		} catch (IOException e) {
			System.err.println("File " + path.getFileName() + " not exist");
			e.printStackTrace();
		}
		return false;
	}

	public static boolean createFile(String path, String fileName, String extension) {
		File dir = new File(path);
	    if (!dir.exists()) {
	        if (dir.mkdirs()) {
	            System.out.println("Folder " + dir.getPath() + " is created successfully.");
	        } else {
	            System.out.println("Failed to create folder " + dir.getPath());
	            return false; 
	        }
	    }
		
		
		StringBuilder sb = new StringBuilder();
		sb.append(path).append("/").append(fileName).append(extension);
		File file = new File(sb.toString());
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("File " + file.getName() + " is created successfully");
				return true;
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println("File " + file.getName() + " is already exist");
		return false;
	}
	

	private static void renameTo(Path source, String newName) {
		String ext = getExt(source.getFileName().toString()); 
		Path parentDir = source.getParent();
		Path targetDir = parentDir.resolve(newName + "." + ext);
		try {
			Files.move(source, targetDir);
			System.out.printf("File %s rename successfully!\n", source.getFileName());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
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
