package lesson1.io.ex01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ScannerConsoleHandler {
    public static void main(String[] args) {
        String separator = File.separator;
        String path = "/home/user/Documents/Hillel/alishev/log.txt";

//        File file = new File(path);
//        try (Scanner scanner = new Scanner(file)) {
//            while (scanner.hasNextLine()) {
//                String str = scanner.nextLine();
//                System.out.println(str);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        scanner.close()  // что бы освобождались ресурсы и поток был открытым

        writeToFile();
    }


    private static void writeToFile() {
        //String path = "/home/user/Documents/Hillel/alishev/newFile.txt";
        String path = "newFile.txt";
        File file = new File(path);

        try  {

            // только для текстовых значений
            PrintWriter pw = new PrintWriter(file);

            //Prints a String and then terminates the line.
            pw.println("Test");
            pw.println("Test");
            pw.println("Test0");

            //Writes a string.
            //pw.write("Test row 1");
            //pw.write("Test row 7");

           pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
