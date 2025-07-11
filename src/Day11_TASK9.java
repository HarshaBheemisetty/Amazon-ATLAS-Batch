
interface Checker {
    boolean check(String str);
}

public class Day11_TASK9 {
    public static void main(String[] args) {
        Checker checker = (str) -> str.length() > 5;
        System.out.println(checker.check("Hello"));     // false
        System.out.println(checker.check("Greetings")); // true
    }
}
