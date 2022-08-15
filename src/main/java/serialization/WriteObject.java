package serialization;

import java.io.*;

/**
 * @author Sergey Klunniy
 */
public class WriteObject {
    public static void main(String[] args) {
        Person person1 = new Person(1, "Bob");
        Person person2 = new Person(2, "Mke");

        try {
            //записывает последовательность байт в файлы, обьект, картинка, звук и тд
            FileOutputStream fos = new FileOutputStream("people.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(person1);
            oos.writeObject(person2);

            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
