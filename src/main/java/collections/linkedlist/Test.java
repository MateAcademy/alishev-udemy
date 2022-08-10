package collections.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> linkedList = new LinkedList<>();
        // head -> [5] -> [1] -> [2] -> [3] -> [4]
        List<Integer> arrayList = new ArrayList<>();
        //[7][6][1][2][3][4][5]

        measureTime(linkedList);
        measureTime(arrayList);

//        linkedList.add(1);
//        linkedList.get(0);
//        linkedList.size();
//        linkedList.remove(0);
        //перейти от линкедлиста к эррей листу
    }

    private static void measureTime(List<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000_000; i++) {
            list.add(i);
            list.add(0, i);
        }

        for (int i = 0; i < 1000_000; i++) {
            list.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    //если добавлять элементы в конец или считывать методом get то лучше arraylist, быстрее в два раза
    //если записывать обьекты в начало, что быстрее?

    //добавить 100_000 єлементов и считать 100_000 элементов
    //добавить новые элементы в лист на позицию 0 - еррей лист проиграл
    //почему время выполнения программы в разных операциях разное? потому что эти два листа имеют абсолютно разную реализацию,
    //эррей лист для хранении информации использует внутренний массив


    // как еррей лист добавлял элементы когда показал себя лучше? [1] [2] [3] [4] [5]  что нужно что бы [6] поместить
    // если в случае еррей листа у нас есть в нутренний массив, в случае линкедлиста - цепочка узлов, цепочка обьектов
    // для каждого класс подходит для своего сценария использования, если мы производим много записей в конец листа или много считываний с листа,
    // мы должны использовать аррей лист

    // если мы производим много удалений или много вставок в начало - линкед лист
}
