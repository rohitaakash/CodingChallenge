import java.util.Arrays;
import java.util.List;

public class MaxDifferenceInAnArray {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1,6,9,55,4);
        System.out.println(maxDifferenceOddEven(a));
    }

    private static int maxDifferenceOddEven(List<Integer> a) {

        if(a.size() == 0) return -1;
        int maxDiff = Integer.MIN_VALUE;
        int minOdd = Integer.MAX_VALUE;
        for (int i = 0; i < a.size(); i++) {
            int num = a.get(i);
            if (num % 2 == 0) {
                int currDiff = num - minOdd;
                if (maxDiff < currDiff  && num > minOdd)
                    maxDiff = currDiff;

            } else {
                if (minOdd > num)
                    minOdd = num;
            }
        }

        if (maxDiff <= 0)
            return -1;
        else
            return maxDiff;

    }

}
