package lesson1.collections.arraylist;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
//        int[] arr = new int[3];
//
//        for (int i = 0; i <= 4; i++) {
//            arr[i] = i;
//        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            arrayList.add(i);
        }

//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println(arrayList.get(i));
//        }

        //еще один способ с помощью которого мы можем проходится по элементам array list это forich:
//        for (Integer x : arrayList) {
//            System.out.println(x);
//        }

//        System.out.println(arrayList);

//        arrayList.forEach(System.out::println);

//сократить размер до 5 и вывести его, теперь мы можем добавлять элементы в наш arraylist,удалять элементы и читать элементы из
// нашего arraylist
//единственно этот метод не очень эффективный
        arrayList.remove(5);  // он очень неэффективный, почему это происходит?
        //все обьекты класса эррейлист используют внутренний массив. [1, 2, , 4, 5, 6]
        //мы удалили под каким индексом элемент?
        //если нужно много опрераций удаления и это не из конца, то лучше отказаться от эррей лист

        //рассказать про джава конвеншин, переменную типа интерфейса.
    }
}
