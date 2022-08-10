package io.ex01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ScannerConsoleHandler {
    public static void main(String[] args) {
        String separator = File.separator;
        String path = "/home/user/Documents/Hillel/alishev/log.txt";

        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        writeToFile();
    }


    private static void writeToFile() {
        String path = "/home/user/Documents/Hillel/alishev/newFile";
        File file = new File(path);

        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println("Test row 1");
            pw.println("Test row 9");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
