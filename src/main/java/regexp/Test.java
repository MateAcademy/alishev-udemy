package regexp;

/*Регулярные выражения это очень мощный инструмент который позволяет нам работать с текстом, позволяет описывать паттерны в тексте*/
public class Test {
    public static void main(String[] args) {

        String a = "1234";
        a.matches("");

        String q = "1234";
        System.out.println(q.matches("1234"));

        String q2 = "1234"; //строка на которой вызывается matches
        System.out.println(q2.matches("1235")); //строка подаваемая в качестве аргументов

        String q3 = "hello";
        System.out.println(q3.matches("1234"));
//      System.out.println( q3.matches("hello"));

        /*  это регулярное выражение означает одна цифра, это не буква а какой-то специальный символ
            это специальные символы:
            \\d - одна цифра
            \\w - одна английская буква
            \\w = [a-zA-Z]

            +   1 или более    (на пустой строке выдаст фолс)
            *   0 или более
            ?   символ который идет до него он может быть или не быть

            (x|y|z) || - для того что бы описывать некие возможности у нас есть скобки

            (a|b|c|d|e|f|g|h)
            [a-zA-Z] - с помощью квадратных скобок мы можем описывать множества
            [0-9] - \\d
            [^abc] - мы хотим все символы кроме [abc]
            . любой символ

            {2} - точное колво предыдущих символов )\\d{2}}
            {2,}  - (\\d{2,})
            {2, 4} - точное колво предыдущих символов (\\d{2,4})
         */

        String r = "d";
        System.out.println(r.matches("d"));

        String r2 = "d";
        System.out.println(r.matches("\\d")); //буква d не соответствует этому регулярному выражению

        String r3 = "1";
        System.out.println(r.matches("\\d"));

        String r4 = "6";
        System.out.println(r.matches("\\d"));  //строка соответствует этому регулярному выражению и строка regex описывает группу строк
        //вот это регулярное выражение описывает такой паттерн строки в котором находится одна цифра

        String r5 = "91";
        System.out.println(r5.matches("\\d"));

        //как нам сказать что хотим видеть один или более
        String b = "235425256256";
        System.out.println(b.matches("\\d+"));
        //это значит что в регул выражении мы описываем одну или более цифр

        String b2 = "";
        System.out.println(b2.matches("\\d+"));  // false

        String d = "";
        System.out.println(d.matches("\\d*"));   //true

        String d2 = "8989797567858";
        System.out.println(d2.matches("\\d*"));   //true

        String e = "-41241";
        System.out.println(e.matches("\\d*")); //регулярное выражение будет отрицательным

        String e2 = "-41241";
        System.out.println(e.matches("-\\d*")); //- и после минуса 0 или более цифр

        String e4 = "41241";
        String e5 = "-41241";
        String e6 = "+41241";
        System.out.println(e4.matches("(-|\\+)?\\d*")); //?  0 или более цифр
        System.out.println(e5.matches("(-|\\+)?\\d*")); //?  0 или более цифр
        System.out.println(e6.matches("(-|\\+)?\\d*")); //?  0 или более цифр
        // два слеша переводят обычную букву в специальный символ и так же спец символ в обычную букву


        String e7 = "g142125";
        System.out.println("e7: " + e7.matches("[a-z][0-9]+"));
        System.out.println("e7: " + e7.matches("[a-z][0-9]+"));

        String e8 = "g142125";
        System.out.println("e8" + e8.matches("[a-zA-Z]+\\d+"));


        System.out.println();
        String e9 = "sdf";
        System.out.println(e.matches("[^abc]*"));

        System.out.println();
        String e10 = "hello";
        System.out.println(e10.matches("[^abc]*"));


        String str = "(78+(3-9) + (5*7)))";
        System.out.println("str: " + str.matches("\\d+\\(\\)\\*\\/\\+\\-"));
        System.out.println("str: " + str.matches("[0-9|\\*|-|\\+|(|)]*"));

        String f = "123";
        System.out.println(f.matches("\\d{2}"));

        //таким образом мы проверили что строка я вляется валидным адрессом вебсайта
        String url = "http://www.goggle.com";
        String url2 = "http://www.yandex.ru";
        String url3 = "http://www.yandex.ru";
        System.out.println(url.matches("|http://www\\..+\\.(com|ru)"));
        System.out.println(url2.matches("|http://www\\..+\\.(com|ru)"));


//        String a = "1234";
//        String a = "1";        а если ввели цифру 5 или
//        String a = "91";        а если ввели цифру 5 или
//        String a = "hello";
//        String a = "daniel";
//        boolean matches = a.matches("1234");
//        boolean matches = a.matches("\\d"); //это регулярное выражение описывает такой паттерн строки в котором находится одна цифра.
//        boolean matches = a.matches("1235");
//        System.out.println(matches);

        Integer i1= 10;
        Integer i2= 10;
        System.out.println(i1==i2);
        Double d1= 10d;
        Double d5= 10d;
        System.out.println(d1==d5);
    }
}
