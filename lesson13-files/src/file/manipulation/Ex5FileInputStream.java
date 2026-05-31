package file.manipulation;

import utils.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.List;

public class Ex5FileInputStream {
    private static final String PATH = "lesson13-files/storage/knowledge.txt";

    public static void main(String[] args) {
        System.out.println("=== Main Page starts ===");

        File file = new File(PATH);

        if (!file.exists()) {
            System.out.println("File " + file.getName() + " is not existed yet ...");
            return;
        }

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            @SuppressWarnings("unchecked")
            List<String> lines = (List<String>) ois.readObject();

            lines.forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            FileUtils.close(ois, fis);
        }

        System.out.println("=== Main Page ends ===");
    }
}
