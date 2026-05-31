package file.manipulation;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import utils.FileUtils;
import model.DataModel;

public class Ex01FileWriterAllLines {

	private static final String PATH = "lesson13-files/storage/template.txt";

	public static void main(String[] args) {
		Set<Entry<String, Integer>> models = DataModel.mockModelMap().entrySet();

		List<String> lines = models.stream()
		        .map(e -> e.getKey() + ": " + e.getValue())
		        .collect(Collectors.toList());
		lines.add(0, "Danh sach bsx: ");
		FileUtils.writeAndOpen(PATH, lines);
		System.out.println("===   Main Page ends ===");
	}

}
