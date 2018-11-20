public class MatrixChainMultiplication {

    public static void main(String[] args) {
//        int[] p = {10, 20, 30, 40, 30};
        int[] p = {40, 20, 30, 10, 30};
        System.out.println(matrixChainOrder(p));
    }

    private static int matrixChainOrder(int[] nums) {
        if (nums.length <= 2) return 0;
        int[][] cache = new int[nums.length + 1][nums.length + 1];

        for (int i = 1; i < nums.length; i++) {
            cache[i][i] = 0;
        }

        return matrixChainOrder(nums, 1, nums.length - 1, cache);
    }

    private static int matrixChainOrder(int[] nums, int i, int j, int[][] cache) {
        if (i == j) return 0;

        if (cache[i][j] != 0) return cache[i][j];

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int count = matrixChainOrder(nums, i, k, cache) + matrixChainOrder(nums, k + 1, j, cache) + nums[i - 1] * nums[k] * nums[j];
            if (count < min)
                min = count;
        }

        cache[i][j] = min;
        return cache[i][j];
    }

}
