import java.util.HashSet;
import java.util.Set;

public class ElevatorStops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] A = {60,80,40};
//		int[] B = {2,3,5};
//		int X = 2, Y = 200;
//		int M = 5;
		
		int[] A = {40,40,100,80,20};
		int[] B = {3,3,2,2,3};
		int X = 5, M = 3, Y=200;
		System.out.println(solution(A, B, M, X, Y));

	}
	
	public static int solution(int[] A, int[] B, int M, int X, int Y) {
		
		int count = 0, cap = 0, wt = 0;
		Set<Integer> floors = new HashSet<Integer>();
		for(int i=0; i<A.length; i++) {
			floors = new HashSet<Integer>();
			cap = 0;
			wt = 0;
			while(cap <= X && wt <= Y && i<A.length) {
				if((wt + A[i] <= Y) && (cap + 1 <= X)) {
					wt += A[i];
					cap++;
					floors.add(B[i]);
					i++;
				}else {
					i--;
					break;
				}
			}
			count += floors.size() + 1;
		}
		return count;
	}
	
	

}
