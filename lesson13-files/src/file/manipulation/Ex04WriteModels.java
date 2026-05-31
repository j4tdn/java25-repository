package file.manipulation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import model.DataModel;
import utils.FileUtils;

public class Ex04WriteModels {

    private static final String PATH = "lesson13-files/storage/example/models-output.txt";

    public static void main(String[] args) {
        System.out.println("=== Main Page starts ===");

        // Lấy dữ liệu giả lập từ DataModel
        Set<Entry<String, Integer>> models = DataModel.mockModelMap().entrySet();

        // Chuyển thành danh sách String
        List<String> lines = models.stream()
            .map(e -> e.getKey() + ":" + e.getValue())
            .collect(Collectors.toList());

        // Thêm tiêu đề vào cuối danh sách
        lines.add("=== Danh sách mã biển số xe theo thành phố tại Việt Nam [06.05.2026] ===");

        File file = new File(PATH);

        if (!file.exists()) {
            System.out.println("File " + file.getName() + " is not existed yet...");
            return;
        }

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            // Ghi danh sách vào file dưới dạng object
            oos.writeObject(lines);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            FileUtils.close(fos, oos);
        }

        System.out.println("=== Main Page ends ===");
    }
}
