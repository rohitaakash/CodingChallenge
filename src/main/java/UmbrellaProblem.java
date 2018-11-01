import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UmbrellaProblem {
    public static void main(String[] args) {
        List<Integer> p = Arrays.asList(3, 2, 4, 5);
        System.out.println(minUmbrella(p, 12));
    }

    private static int minUmbrella(List<Integer> p, int n) {
        if (n == 0) return 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i) <= n) {
                int sub_result = minUmbrella(p, n - p.get(i));
                if (sub_result != Integer.MAX_VALUE && sub_result + 1 < result){
                    result = sub_result + 1;
                }
            }
        }
        return result;
    }


}
