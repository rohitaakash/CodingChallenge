import java.util.HashSet;
import java.util.Set;

public class MaximalFruit {

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 3, 4, 3, 5, 1, 2};
        int[] B = {1, 2, 1, 2, 1, 2, 1};
        int[] C = {1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 1};
        int[] D = {1, 0, 3, 4, 3};
        System.out.println(maximalFruit(A));
        System.out.println(maximalFruit(B));
        System.out.println(maximalFruit(C));
        System.out.println(maximalFruitOptimized(A));
        System.out.println(maximalFruitOptimized(B));
        System.out.println(maximalFruitOptimized(C));
        System.out.println(maximalFruitOptimized(D));
    }

    private static int maximalFruit(int[] A) {
        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            Set<Integer> set = new HashSet<>();
            int count = 0;
            for (int j = i; j < A.length; j++) {
                set.add(A[j]);
                if (set.size() <= 2)
                    count++;
                else
                    break;
            }

            if (maxCount < count)
                maxCount = count;
        }
        return maxCount;
    }

    private static int maximalFruitOptimized(int[] tree) {

        if (tree.length < 3) return tree.length;

        int maxCount = Integer.MIN_VALUE, count = 2, prev_index = 0;
        Set<Integer> set = new HashSet<>();
        set.add(tree[0]);
        set.add(tree[1]);
        for (int i = 2; i < tree.length; i++) {
            if (set.contains(tree[i])) {
                count++;
            } else {
                if (set.size() == 2) {
                    set.remove(tree[prev_index]);
                    count = i - prev_index;
                } else {
                    count++;
                }
                set.add(tree[i]);
            }

            if (tree[i] != tree[i-1]) {
                prev_index = i-1;
            }

            if (maxCount < count)
                maxCount = count;

        }
        return maxCount;
    }

}
