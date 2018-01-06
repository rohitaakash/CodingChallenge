
public class TwoKeysKeyboard {

	public int minSteps(int n) {
		int[] cache = new int[n+1];
		
		return minStepsHelper(n, cache);
	}
	
	public int minStepsHelper(int n, int[] cache) {
		if(n == 0 || n== 1) return 0;
	
		if(cache[n] != 0) return cache[n];
		
		if(isPrime(n)) cache[n] = n;
		
		if(cache[n] == 0) {
			for(int i = 2; i <= n; i++) {
				if(n%i == 0) {
					cache[n] = minStepsHelper(i, cache) + minStepsHelper(n/i, cache);
				}
			}
		}
		
		return cache[n];
	}

	public boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	
	public int minSteps2(int n) {
		if (n == 1) return 0;
        for (int i = 2; i < n; i++)
            if (n % i == 0) return i + minSteps(n / i);
        return n;
	}

	public static void main(String[] args) {
		TwoKeysKeyboard tkk = new TwoKeysKeyboard();
		System.out.println(tkk.minSteps2(18));
		System.out.println(tkk.minSteps(18));
	}
}
