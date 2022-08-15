package lesson2.множества;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Sergey Klunniy
 */
public class Test {
    public static void main(String[] args) {
        //ве то же самое как и с мэп
        // хранят в себе одиночные элементы но не допускаются одинаковые элементы
        Set<String> hashSet = new HashSet<>(); // нет никакого поряядка
        Set<String> linkedHashSet = new LinkedHashSet<>(); // сохраняется порядок ввода элементов
        Set<String> treeSet = new TreeSet<>(); //обьекты сортируются в их естественном порядке а<b

        hashSet.add("ZMike");
        hashSet.add("Mike");
        hashSet.add("Katy");
        hashSet.add("Tom");
        hashSet.add("George");
        hashSet.add("Donald");

        hashSet.add("Tom");
        hashSet.add("Tom");

        linkedHashSet.add("Mike");

        for (String name : hashSet) {
            System.out.println(name);
        }

        //теперь дабвайте разберемся с методами:
        //контейнс есть ли элемент
        boolean tom = hashSet.contains("Tom");
        System.out.println(tom);
        System.out.println(hashSet.contains("Tim")); //work fast

        System.out.println(hashSet.isEmpty());

        //java set - documentation java

        //показать как сет обрабатывает дубликаты, положить имя еще два раза

       //мы можем выводить:
        System.out.println(hashSet);

        //есть теория множества, это мешок в котором хранятся элементы от 0 -100  50-150
        //пересечение 50-100 числа беруться в единств результате
        //обьединение
        //разность



    }
}
