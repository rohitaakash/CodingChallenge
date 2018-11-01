
public class L62UniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePaths(7, 3));
	}

	public static int uniquePaths(int m, int n) {
		int[][] cache = new int[m + 1][n + 1];
		cache[m][n] = 1;
		return getUniquePathsTopDown(1, 1, cache);
	}

	public static int getUniquePathsTopDown(int startX, int startY, int[][] cache) {
		if (cache[startX][startY] != 0)
			return cache[startX][startY];
		
		int right = 0, down = 0;
		if (startX < cache.length-1)
			right = getUniquePathsTopDown(startX + 1, startY, cache);
		if (startY < cache[0].length-1)
			down = getUniquePathsTopDown(startX, startY + 1, cache);
		
		cache[startX][startY] = right + down;
		return cache[startX][startY];
	}
}
