import java.util.Arrays;

public class L64MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
        System.out.println(minPathSumBottomUp(grid));
    }

    private static int minPathSum(int[][] grid) {
        int[][] cache = new int[grid.length][grid[0].length];

        for (int[] aCache : cache) {
            Arrays.fill(aCache, -1);
        }

        cache[0][0] = grid[0][0];
        return minPathSumTopDown(grid, grid.length - 1, grid[0].length - 1, cache);
    }

    private static int minPathSumTopDown(int[][] grid, int row, int col, int[][] cache) {
        if (row < 0 || col < 0) return Integer.MAX_VALUE;
        if (cache[row][col] != -1) return cache[row][col];
        cache[row][col] = grid[row][col] + Math.min(minPathSumTopDown(grid, row - 1, col, cache), minPathSumTopDown(grid, row, col - 1, cache));
        return cache[row][col];
    }

    private static int minPathSumBottomUp(int[][] grid) {
        int[][] cache = new int[grid.length][grid[0].length];

        cache[0][0] = grid[0][0];

        for (int i = 1; i < grid.length; i++) {
            cache[i][0] = grid[i][0] + cache[i - 1][0];
        }

        for (int i = 1; i < grid[0].length; i++) {
            cache[0][i] = grid[0][i] + cache[0][i - 1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                cache[i][j] = grid[i][j] + Math.min(cache[i - 1][j], cache[i][j - 1]);
            }
        }

        return cache[grid.length - 1][grid[0].length - 1];
    }
}
