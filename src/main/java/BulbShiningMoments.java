import java.util.TreeSet;

public class BulbShiningMoments {
    public static void main(String[] args) {
        int[] A = {2, 1, 3, 5, 4};
        int[] B = {2, 3, 4, 1, 5};
        int[] C = {1, 2, 3, 4, 5};
        int[] D = {5, 4, 3, 2, 1};
        System.out.println(bulbShiningMomentsOptimized(A));
        System.out.println(bulbShiningMomentsOptimized(B));
        System.out.println(bulbShiningMomentsOptimized(C));
        System.out.println(bulbShiningMomentsOptimized(D));
    }

    private static int bulbShiningMomentsOptimized(int[] A) {
        TreeSet<Integer> set = new TreeSet<>();
        int moments = 0, sum = 0;
        for (int aA : A) {
            set.add(aA);
            sum += aA;
            int actualSum = set.last() * (set.last() + 1) / 2;
            if (sum == actualSum)
                moments++;

        }
        return moments;
    }

}
