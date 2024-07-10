import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /**
     * Returns the total sum in a list of integers
     */
    public static int sum(List<Integer> L) {
        int sum = 0;
        for (Integer i : L) {
            sum = sum + i;
        }
        return sum;
    }

    /**
     * Returns a list containing the even numbers of the given list
     */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> evenNum = new ArrayList<>();
        for (Integer i : L) {
            if (i % 2 == 0) {
                evenNum.add(i);
            }
        }
        return evenNum;
    }

    /**
     * Returns a list containing the common item of the two given lists
     */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> common = new ArrayList<>();
        for (Integer i : L1) {
            for (Integer integer : L2) {
                if (i == integer && !common.contains(integer)) {
                    common.add(integer);
                }
            }
        }
        return common;
    }


    /**
     * Returns the number of occurrences of the given character in a list of strings.
     */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int cnt = 0;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
