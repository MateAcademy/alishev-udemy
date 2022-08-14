package lesson2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Sergey Klunniy
 */
public class LinkedHashMap2 {
    public static void main(String[] args) {
//        Map<String, String> translators = new HashMap<>();
//        translators.put("кошка", "cat");
//        translators.put("собака", "dog");
//        translators.put("слон", "elephant");
//
//        for (Map.Entry<String, String> entry :translators.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        //и мы видем чт не обеспечен порядок

        Map<Integer, String> hashMap = new HashMap<>(); // внутри не гарантируется порядок

        // в каком порядке пары ключзначение были добавлены в таком порядке они и вернуться
        Map<Integer, String> linkedHashMap =  new LinkedHashMap();

        //в каком порядке были добавлены, будут отсортированы по ключу
        //пары (ключб значения) сортируются по ключу  естественный порядок
        Map<Integer, String> treeMp = new TreeMap<>();

        testMap(linkedHashMap);
    }

    //давайте создадим метод в котором будем тестировать все три обьекта
    public static void testMap(Map<Integer, String> map) {
        map.put(39, "Bob");
        map.put(12, "Mike");
        map.put(78, "Tom");
        map.put(0, "Tim");
        map.put(1500, "Lewis");
        map.put(7, "Bob");

        //не могут быть один ключи но значения могут

        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
