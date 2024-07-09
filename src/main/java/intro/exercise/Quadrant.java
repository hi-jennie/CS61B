package intro.exercise;

public class Quadrant {
    public static void main(String[] args) {
        System.out.println(quadrant(-2.3, 3.5));
    }

    public static int quadrant(double x, double y) {
        if (x > 0) {
            if (x * y > 0) {
                return 1;
            } else if (x * y < 0) {
                return 4;
            } else {
                return 0;
            }
        }
        if (x < 0) {
            if (x * y > 0) {
                return 3;
            } else if (x * y < 0) {
                return 2;
            } else {
                return 0;
            }
        }
        return 0;
    }
}
