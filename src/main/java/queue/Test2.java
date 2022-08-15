package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Test2 {
    public static void main(String[] args) {
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);
        Person person5 = new Person(5);

        //зайти в джава доки этот класс используется когда у нас много потоков и мы ограничиваем доступ к общим ресурсам
        //можем указать
        Queue<Person> people = new ArrayBlockingQueue<Person>(2);
        people.add(person3);
        people.add(person2);
//        people.add(person4);
//        people.add(person1);

        System.out.println(people.remove());
        System.out.println(people.peek());
        System.out.println(people);

        //различия между методами это спецификация
    }
}
