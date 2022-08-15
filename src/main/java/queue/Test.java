package queue;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        //первый пришел первый и заходит мы можем вытащивать в том порядке в котором их поместили

        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);
        Person person5 = new Person(5);

        //давайте добавим их поособенному
        Queue<Person> people = new LinkedList<>();
        people.add(person3);
        people.add(person2);
        people.add(person4);
        people.add(person1);

        System.out.println(people);
        //person3 <- person2 <- person4 <-person1

        for (Person person : people) {
            System.out.println(person);
        }

        //cоотношение фест ин фест оут соблюдается

        //эррей блокинг кю многозадачность, когда у нас есть много потоков и мы ограничиваем доступ к общим ресурсам
    }
}

class Person {
    private int id;

    public Person(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}