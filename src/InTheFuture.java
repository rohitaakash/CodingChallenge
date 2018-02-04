
public class InTheFuture {
	public static void main(String[] args) {
		System.out.println(minNum(4, 5, 1));
	}

	public static int minNum(int A, int K, int P) {
		
		if (K <= A) return -1;
		
		if(P == 0) return 1;
		
		int days = 0, solvedByA = 0, solvedByK = -P;
		
		while(true) {
			solvedByA += A;
			solvedByK += K;
			days++;
			if (solvedByK > solvedByA)	break;
		}

		return days;
	}

}
