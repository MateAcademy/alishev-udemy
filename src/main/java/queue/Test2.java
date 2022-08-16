package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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

        Stack<Integer> stack = new Stack<>();
        // 5<-3<-1 если очередь то получим 5 но в случае со стеком мы получим последний добавленный элемент.
        stack.push(5);
        stack.push(3);
        stack.push(1);

        stack.pop(); //достает последний добавленный элемент из стека - вывести на экран
        stack.pop(); //достает последний добавленный элемент из стека - вывести на экран
        stack.pop(); //достает последний добавленный элемент из стека - вывести на экран
        stack.pop(); //не осталось элементов
        stack.peek(); //не осталось элементов
    }
}
