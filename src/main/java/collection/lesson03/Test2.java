package collection.lesson03;

import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        List<Person2> peopleList = new ArrayList<>();
        Set<Person2> personSet = new TreeSet<>();

        addElements(peopleList); // на обьектах класса персон задать естественный порядок
        //ввести другой апорядок сортировки, по длине имени
        addElements(personSet);

        Collections.sort(peopleList);
    }

    private static void addElements(Collection collection) {
        collection.add(new Person(1, "Bob"));
        collection.add(new Person(2, "Tom"));
        collection.add(new Person(3, "Katy"));
        collection.add(new Person(4, "George"));
    }
}

//обьекты сортируемые, на них определен некий порядок
//comparator - тот кто сравнивает
//компарабле - способный быть сравниваемым, годящийся для сравнения
class Person2 implements Comparable<Person2> {
    private int id;
    private String name;

    public Person2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person2 person2 = (Person2) o;
        return id == person2.id && Objects.equals(name, person2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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

    @Override
    public int compareTo(Person2 o) {
        if (this.id > o.getId()) {
            return 1;
        } else if (this.id < o.getId()) {
            return -1;
        } else {
            return 0;
        }

    }
}