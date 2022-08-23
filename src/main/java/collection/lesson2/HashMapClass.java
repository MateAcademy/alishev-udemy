package collection.lesson2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey Klunniy
 */
public class HashMapClass {
    public static void main(String[] args) {
        //показать картику java collections framework
        //класс самый полезный и часто используемый?
        // карта или отображение, это тот случай когда есть два множества и мы элементы одного множества сопоставляем элементы второго множества
        // 1 - [.. .. ..]
        // 2 - [.. .. ..]

        Map<Integer, String> map = new HashMap<>();
        //все мли экземпляры хранят пары ключ значения?
        //мы хотим связать ключи и значения связанны ес этим числом

        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        System.out.println(map);

        //давай создадим коллекцию которая будет хранить мапу, и посмотрим как она себя ведет при вставке новых пар ключ значение
        map.put(3, "THREE");

        //вставь новую пару ключ значение с ключом три, мы увидем что старое значение переписывается
        System.out.println(map);

        //а напиши карту но что бы порядок вывода был хаотичным?

        //получи значение по ключу?

        System.out.println(map.get(9));
        //если пары ключ значение не существует, вернется что? нулл
        
        //теперь давай пройдемся по мэп циклом форич
// каждая пара ключ значение это ентри, это рассматривается как пара
        //и здесь мыы получаем доступ к этой структуре данных, этот метод возвращает набор всех пар ключ значение
        //набор всех обьектов класса entry
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


        //элементы пары ключ значение имеют ли порядок, гарантирует ли порядок, давай получим абсолютно случайный вывод, и все это меняется из каждым запуском программы, используется хеширование,
        //используйте хеш мэп в том случае когда не важен порядок ключ значение, вам важно просто их наличие

        //если вам важен или их нужно отсортировать, используйте другие классы, какие?

        //какая слабая сторона хешмеп? нет никаково порядка, данные выдаются случайным образом

    }
}