import java.util.HashSet;
import java.util.Set;

public class DistinctPairs {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 6, 7, 8, 9, 1};
        int k = 10;
        System.out.println(numberOfPairs(a, k));
    }

    private static int numberOfPairs(int[] a, int k) {
        int total = 0;
        Set<Integer> distinctNums = new HashSet<>();
        for(int i=0; i<a.length; i++) {
            distinctNums.add(a[i]);
        }

        for(int num: a) {
            if(distinctNums.contains((k-num))){
                distinctNums.remove(num);
                distinctNums.remove((k-num));
                total++;
            }
        }

        return total;
    }
}
