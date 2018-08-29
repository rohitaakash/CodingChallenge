
public class L651FourKeysKeyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxA(100));
	}

	public static int maxA(int N) {
		int[] cache = new int[N + 1];
		cache[0] = 0;
		cache[1] = 1;

//		return maxATopDownDP(cache, N);
		return maxABottomUpDP(N);
	}

	public static int maxATopDownDP(int[] cache, int N) {
		
		return cache[N];
	}

	public static int maxABottomUpDP(int N) {

		if (N <= 0)
			return 0;

		int[] cache = new int[N + 1];

		return cache[N];
	}
}
