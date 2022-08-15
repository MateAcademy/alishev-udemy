package lesson03;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        //отсортируем строки по их длинам, заменим стандартный порядок сортировки и внесем свой
        //коллекции которые сохраняют порядок, hashset -не
        // три сет, три меп и арр лист - да

        List<String> animals = new ArrayList<>();

        animals.add("abrgf");
        animals.add("dog");
        animals.add("cat");
        animals.add("frog");
        animals.add("a");
        animals.add("bird");
        animals.add("ab");

        Collections.sort(animals, new StringLengthComparator());
        System.out.println(animals);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(0);
        numbers.add(500);
        numbers.add(100);

        Collections.sort(numbers, new BackwardsIntegerComparator()); //natural order порядок по умолчанию, в обычном возрастающем порядке, естественный порядок, но что если этот порядок нам не подходит, если мы хотим отсортировать строки по их длине,
        System.out.println(numbers);

        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else if (o1 < o2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        //компаратор


//        List<Person> people = new ArrayList<>();
//        people.add(1, "Bob");
//        people.add(2, "Katy");
//        people.add(3, "Mike");

        //Collections.sort(people); // попробуем отсортировать наш лист, мы не задали естественного порядка
        //Collections.sort(people, new Comparator<Person>() {
        // ..... по id});
    }
}

class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        /* вот такая конвенция
        o1 > o2 =>1
        o1 < o2 =>-1
        o1 == o2 =>0

        compare(2, 1) =>1
        compare(1, 2) =>-1
        compare(1, 1) =>0
         */

        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 0;
        }
    }
}

class BackwardsIntegerComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2) {
            return 1;
        } else if (o1 < o2) {
            return -1;
        } else {
            return 0;
        }
    }
}

//давайте реализуем компаратор для сравнения наших собственных обьектов
class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}