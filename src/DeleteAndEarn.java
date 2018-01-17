
public class DeleteAndEarn {

	public static long deleteEarn(int[] elements) {
		int[] counter = new int[100001];

		long discard = 0, consider = 0, previous = -1;
		for (int i = 0; i < elements.length; i++) {
			counter[elements[i]]++;
		}

		for (int j = 0; j < 100001; ++j) {
			if (counter[j] > 0) {
				long max = Math.max(discard, consider);
				if (j - 1 == previous) {
					consider = discard + j * counter[j];
				} else {
					consider = max + j * counter[j];
				}
				discard = max;
				previous = j;
			}
		}

		return Math.max(discard, consider);
	}
	
	public static void main(String[] args) {
		
	}
}
