package collection.lesson2.множества;

import serialization.Person;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Sergey Klunniy
 */
public class Test2 {
    //давайте создадим множества чисел

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);


        //union - обьединение множеств
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        System.out.println(union);

        //intersection - пересечение мноожеств
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println(intersection);

        //difference - разность множеств
        Set<Integer> difference = new HashSet<>(set1);
        difference.retainAll(set2);

        System.out.println(difference);

        //Методы hashcode() equals() и контракт hashcode() equals(), хеширование
// в сете только уникальные элементы

        Map<Integer, String> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        map.put(1, "One");
        map.put(1, "другое значение");

        set.add(1);
        set.add(1);

        System.out.println(map);
        System.out.println(set);
        //ключи мепа уникальны и значения сета тоже уникальны

        boolean x = 1==2;
        System.out.println(x);
        //можем ли мы параметризовывать коллекции примитивами, автоупаковывание примит в интежер
        //эти обьекты сравниваются и проверяются на идентичность

        //давайте наш собственный обьект добавим




    }
}

class Paerson {
    private int id;
}
