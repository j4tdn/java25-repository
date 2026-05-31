package files.manipulation;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import model.DataModel;
import utils.FileUtils;

public class Ex01FileWriterAllLines {

    private static final String PATH = "lesson13-files/storage/template.txt";

    public static void main(String[] args) {
        System.out.println("=== Main Page starts ===");

        // input
        Set<Entry<String, Integer>> models = DataModel.mockModelMap().entrySet();

        final List<String> lines = models.stream()
                .map(e -> e.getKey() + ": " + e.getValue())
                .collect(Collectors.toList());

        lines.add(0, "=== Danh sách mã biển số xe theo thành phố tại Việt Nam [06.05.2026] ===");
        
        FileUtils.writeAndOpen(PATH, lines);
        
        System.out.println("=== Main Page ends ===");
    }
	
}
