package intro.exercise;

public class PrintIndexed {
    public static void main(String[] args) {
        printIndexed("wang");
    }

    public static void printIndexed(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i));
            System.out.print(str.length() - i - 1);
        }
    }
}
