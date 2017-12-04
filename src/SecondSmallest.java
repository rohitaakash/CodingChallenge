
public class SecondSmallest {

	public static int secondSmallest(int[] arr) {
		if(arr.length < 2) return 0;
		
		int secMin = (arr[0]>arr[1])?arr[0]:arr[1];
		int min = (arr[1]>arr[0])?arr[0]:arr[1];
		
		for (int i = 2; i < arr.length; i++) {
			if(arr[i] < min) {
				secMin = min;
				min = arr[i];
				
			}else if(arr[i] < secMin) {
				secMin = arr[i];
			}
			
		}
		return secMin;
	}
	
	public static void main(String[] args) {
		int[] arr = {5,2,1,4,3,0};
		System.out.println(secondSmallest(arr));
	}
}
