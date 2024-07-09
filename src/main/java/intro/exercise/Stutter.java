package intro.exercise;

public class Stutter {
    public static void main(String[] args) {
        System.out.println(stutter("wang"));
    }

    public static String stutter(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < 2; j++) {
                result = result + str.charAt(i);
            }
        }
        return result;
    }
}
