import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] getTwoSum(int[] arr, int target) {
		
		int[] tempArr = new int[arr.length];
		
		for (int i = 0; i < tempArr.length; i++) {
			tempArr[i] = arr[i];
		}
		
		Arrays.sort(tempArr);
		
		int a=0, b=0;
		
		int i=0, j=tempArr.length-1;
		
		while(i<j) {
			if(tempArr[i] + tempArr[j] < target) {
				i++;
			}else if(tempArr[i] + tempArr[j] > target) {
				j--;
			}else {
				a = tempArr[i];
				b = tempArr[j];
				break;
			}
		}
		
		int aIndex = 0, bIndex = 0;
		for (int j2 = 0; j2 < arr.length; j2++) {
			if(a == arr[j2]) aIndex = j2;
			if(b == arr[j2]) bIndex = j2;
		}
		
		int[] output = new int[2];
		output[0] = aIndex;
		output[1] = bIndex;
		return output;
	}
	
	public static int[] getTwoSum2(int[] arr, int target) {
		Map<Integer, Integer> arrMap = new HashMap<>();
		int aIndex = 0, bIndex = 0;
		
		for (int i = 0; i < arr.length; i++) {
			arrMap.put(arr[i], i);
			if(arrMap.containsKey(target-arr[i])) {
				aIndex = i;
				bIndex = arrMap.get(target-arr[i]);
				break;
			}
		}
		
		int[] output = new int[2];
		output[0] = aIndex;
		output[1] = bIndex;
		return output;
		
	}

}
