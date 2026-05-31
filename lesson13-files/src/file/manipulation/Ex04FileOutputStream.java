package file.manipulation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import utils.FileUtils;
import model.DataModel;

public class Ex04FileOutputStream {

    private static final String PATH = "lesson13-files/storage/knowledge.txt";

    public static void main(String[] args) {
        System.out.println("=== Main Page starts ===");
        
        FileUtils.writeObjectAndOpen(PATH, DataModel.mockAppleList());
    }
}
