package intro.exercise;

public class Spikey {
    public static void main(String[] args) {
        String baSl = "\\";
        String sl = "/";
        int j = 0;
        String[] reversedPattern = new String[6];

        for (int i = 0; i < 3; i++) {
            System.out.printf("%3s", baSl);
            System.out.printf("%-3s", sl);

            reversedPattern[j] = baSl;
            reversedPattern[j + 1] = sl;
            j += 2;
            // String m = "hello";
            // m = STR."\{m}world";
            baSl = STR."\{baSl}\\";
            sl = STR."\{sl}/";
            System.out.println();

        }

        for (int i = 5; i >= 0; i -= 2) {
            System.out.printf("%3s", reversedPattern[i]);
            System.out.printf("%-3s", reversedPattern[i - 1]);
            System.out.println();
        }
        int x = 10;
        int y = 20;
        String result = STR."\{x} + \{y} = \{x + y}";

    }
}

