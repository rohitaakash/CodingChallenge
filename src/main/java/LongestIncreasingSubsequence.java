public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println(lisBottomUp(arr));
		System.out.println(lisBottomUpEfficient(arr));

	}

	
	public static int lisBottomUp(int[] arr) {
		if(arr.length == 0) return 0;
		int[] cache = new int[arr.length];
		int max = 0;
		
		cache[0] = 1;
		
		for(int i=1; i<cache.length; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i] && cache[i] < cache[j] + 1)
					cache[i] = cache[j];
			}
			cache[i] = cache[i] + 1;
			if(max < cache[i]) max = cache[i];
		}
		
		return max;
	}
	
	public static int lisBottomUpEfficient(int[] arr) {
		if(arr.length == 0) return 0;
		int[] lis = new int[arr.length];
		lis[0] = arr[0];
		
		int last = 0;
		for(int i=1; i<arr.length; i++) {
			if(arr[i] > lis[last]) {
				lis[++last] = arr[i];
			}else {
				if(binarySearch(lis, 0, last, arr[i]) != -1) 
					lis[binarySearch(lis, 0, last, arr[i])] = arr[i];
			}
		}
		return last+1;
	}
	
	public static int binarySearch(int[] lis, int start, int end, int key) {
		if(start > end) return -1;
		int mid = (start + end)/2;
		
		if(start == end) return mid;
		if(lis[mid]<key) return binarySearch(lis, mid+1, end, key);
		else return binarySearch(lis, start, mid, key);
	}
}
