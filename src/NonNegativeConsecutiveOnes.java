
public class NonNegativeConsecutiveOnes {

	public static int findIntegers(int num) {

		int[] cache = new int[num + 1];
		cache[0] = 1;
		int count = 0;
		for (int i = 0; i <= num; i++) {
			if (checkBinary(i, cache, num) == 1)
				count++;
		}

		return count;

	}

	public static int checkBinary(int n, int[] cache, int num) {
		if (cache[n] != 0) {
			return cache[n];
		}

		if (n % 2 == 1 && (n / 2) % 2 == 1) {
			cache[n] = -1;
		} else {
			cache[n] = checkBinary(n / 2, cache, num);
		}
		
		for (int i = n; i <= num; i = i * 2) {
			cache[i] = cache[n];
		}
		return cache[n];
		
		
	}

	public static void main(String[] args) {

		System.out.println(findIntegers(123456789));
		
		System.out.println();

	}

}
