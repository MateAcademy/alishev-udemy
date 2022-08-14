package lesson1.io.ex01;

import java.io.*;

public class BafferedReaderConsoleHandler {
    public static void main(String[] args) {

        try (FileInputStream path = new FileInputStream("/home/user/Documents/Hillel/alishev/CONNECTION_LEAK_LOG.log");
             BufferedReader br = new BufferedReader(new InputStreamReader(path))) {

            StringBuilder sb = new StringBuilder();
            String strFromFile;

            while ((strFromFile = br.readLine()) != null) {
                sb.append(strFromFile + "\n");
            }

            System.out.println(sb);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
