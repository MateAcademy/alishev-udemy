package lesson2.множества;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Sergey Klunniy
 */
public class Test3 {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        Set<Person> set = new HashSet<>();

        Person person1 = new Person(1, "Mke");  //это одинаковые люди хоть и разные обьекты
        Person person2 = new Person(1, "Mke");
        //Person2 person3 = new Person2(2, "Katy");

        map.put(person1, "123");
        map.put(person2, "123");

        set.add(person1);
        set.add(person2);

        System.out.println(map);
        System.out.println(set);

        //меп допустил что у нас два одинаковых ключа,
        //сет допустил такую ситуацию что у нас два раза повторяется один и тот же обьект

        //если мы не определим методы хешкод и иквылс мы сможемм два одинаковых обьекта добавить
        //почему это не происходит со строками?

        Set<String> set1 = new HashSet<>();
        set1.add("Hello");
        set1.add("Hello");
        System.out.println(set1);

        Integer x = 1;
        System.out.println(x.hashCode());

        //equals hashcode() мы не декларировали и не реализовывали, для всех разных обьектов эти методы возвращают то что это разные обьекты
        //посмотреть хешкод и иквлс в строках и == не правильно сравнивать строки
        //сравнивают обьекты как участки памяти
        //зачем нам нужно два метода? проходимся по всем значимым полям которые мы включили

        //хеширование, это преобразование массива входных данных произвольной длины в выходную битовую строку фиксированной длины
        //функция реализующая алгоритм и выполняющая преоюразование называется хеш функцией или функцией свертки
        //это функция котороая преобразует обьект любой длины кнвертируется в целое число
        //что-то произвольной длины в что-то фиксированной длины
        //таким образом мы любому обьекту сопоставляем целое число

        //рассказать за коллизию, ограниченое количество целых чисел 32 бита

        /*
        контракт hashcode() equals()

        1) У двух проверяемых обьектов вызываем метод hashcode()
        если хэши разные - два обьекта точно разные.

        2) если хеши одинаковые -> equals()

        3) equals() -> выдает ответ

        функция хешкод, это быть быстрой и гарантировать минимальное количество коллизий,чем  м
        еньше коллизий мы меньше вызываем метод еквылс

        хеш сет в своей реализации использует хешмеп - это та коллекция которая хранит уникальные значения
        в хеш меп уникальные ключи, не может быть такого с двумя одинаковыми ключами
        хеш сет не имеет собственной реализации

        хеш меп? внутри себя использует в реализации массив связных списков
        пут и гет по ключу() - очень быстро
        это массив линкед листов


        получение остатка от целочисленного деления
        index = hash &(n-1)

        логика хеширования и получения индекса
        что было бы если у нас плохая хеш функция

         */

    }
}
