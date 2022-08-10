package collections.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list = new LinkedList<>(list);  //нужно не забыть перенести все элементы

        System.out.println(list);

        //рассказать об устройстве, как он работает?
        //врятли мы будем смотреть все методы которые есть в классах

        // в гугле array list java https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html

        //go to implementation
        //defaultcapasity = 10 это размер внутреннего массива
        //несколько конструкторов

        //arrayCoppyOf    ?
        //systemArrayCopy ?

        //если в  нашей коллекции 10 элементов а мы хотим получить под индексом 100 ?


        //таким образом arraylist в своей реализации использует обычный массив
        //можете сами написать реализацию динамического массива?
        //необезательно досконально знать, должны знать как он устроен как работает, в нутри листа есть массив, в слечае его заполнения создается новый массив и ...
        //читать чужой код очень полезно это развивает ваши навыки программирования а тем более когда код написан разработчиками языка джавасф
    }
}
