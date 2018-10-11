import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KDifferencePairs {
    private static int kDifference(List<Integer> a, int k) {
        int result = 0;
        Set<Integer> set = new HashSet<>(a);

        for(Integer i: a) {
            if(set.contains(i+k)){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1,1,3,5);
        System.out.println(kDifference(a,2));
    }
}
