package regexp;

/**
 * @author Sergey Klunniy
 */
public class Calculator {
    public static void main(String[] args) {
        String calculate = "(57$-((-5+9)5+67/(90+9))";
        System.out.println(calculate.matches("[\\d()*/+-]*"));
        System.out.println(calculate.matches("\\((.*?)\\)"));
    }
}
