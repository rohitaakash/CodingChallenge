
public class CountingSteps {

	public static long countSteps(int n) {
		long[] cache = new long[n+1];
		
		
		return countStepsHelper(n, cache);
	}
	
	public static long countStepsHelper(int n, long[] cache) {
		if(n < 1) return 0;
		
		if(cache[n] > 0) return cache[n];
		
		cache[n] = 1 + countStepsHelper(n-1, cache) + countStepsHelper(n-2, cache) + countStepsHelper(n-3, cache);
		return cache[n];
	}
	
	public static void main(String[] args) {
		System.out.println(countSteps(100));
	}
}
