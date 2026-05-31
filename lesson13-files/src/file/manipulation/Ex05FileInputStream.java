package file.manipulation;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import bean.Apple;
import utils.FileUtils;

public class Ex05FileInputStream {

    private static final String PATH = "lesson13-files/storage/knowledge.txt";

    public static void main(String[] args) {
        System.out.println("=== Main Page starts ===");
//
//        File file = new File(PATH);
//
//        if (!file.exists()) {
//            System.out.println("File " + file.getName() + " is not existed yet ...");
//            return;
//        }
//
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//
//        try {
//            fis = new FileInputStream(file);
//            ois = new ObjectInputStream(fis);

            @SuppressWarnings("unchecked")
            List<Apple> inventory = (List<Apple>)FileUtils.readObject(PATH);
            inventory.forEach(System.out::println);

//            lines.forEach(System.out::println);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            FileUtils.close(ois, fis);
//        }

        System.out.println("=== Main Page ends ===");
    }
}