package serialization;

import java.io.Serializable;

/**
 * @author Sergey Klunniy
 */
public class Person implements Serializable {
    private int id;
    private String name;

    @Override
    public String toString() {
        return id + " : " + name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
