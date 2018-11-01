import java.util.Arrays;

public class BikeParking {
	
	public static void main(String[] args) {
		
//		int[] n = {10,0,8,2,-1,12,11,3};
//		int[] n = {5,5};
		int[] n = {-1};
		System.out.println(bikeParkingDistance(n));
		
	}
	
	public static int bikeParkingDistance(int[] n) {
		
		Arrays.sort(n);
		int min = 0;
		for(int i=1; i<n.length; i++) {
			if((n[i] - n[i-1])/2 > min) {
				min = (n[i] - n[i-1])/2;
			}
		}
		return min;
	}

}
