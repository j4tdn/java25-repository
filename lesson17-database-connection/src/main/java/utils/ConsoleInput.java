package utils;

import java.io.Console;
import java.util.Scanner;

public final class ConsoleInput {

    private ConsoleInput() {
    }

    public static char[] readPassword(Scanner scanner, String prompt) {
        Console console = System.console();
        if (console != null) {
            return console.readPassword("%s", prompt);
        }
    
        System.out.print(prompt);
        return scanner.nextLine().toCharArray();
    }
}
