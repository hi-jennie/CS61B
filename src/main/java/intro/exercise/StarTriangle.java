package intro.exercise;

public class StarTriangle {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        int m = 10 / 3;
        System.out.println(m);
    }
}
