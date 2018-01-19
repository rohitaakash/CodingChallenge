import java.util.Arrays;
import java.util.Comparator;

public class CardinalitySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 900000;
		int[] nums = new int[100000];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = ++num;
		}
		
		cardinalitySort1(nums);
		
		int[] nums2 = {1,2,3,4,5};
		cardinalitySort2(nums2);
		
		for (int i = 0; i < nums2.length; i++) {
			System.out.println(nums2[i]);
		}
	}
	
	private static int[] cardinalitySort1(int[] nums) {
		Integer[] numsArray = new Integer[nums.length];
		
		for(int i=0; i<numsArray.length; i++) {
			numsArray[i] = nums[i];
		}
		Arrays.sort(numsArray, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(getCardinality1((int)o1) == getCardinality1((int)o2)) return o1 - o2;
				else return getCardinality1((int)o1) - getCardinality1((int)o2);
			}
		});
		
		for(int i=0; i<nums.length; i++) {
			nums[i] = numsArray[i];
		}
		
		return nums;
	}
	
	private static int getCardinality1(int num) {
		String binary = Integer.toBinaryString(num);
		int cardinality = 0;
		for(int i=0; i<binary.length(); i++) {
			if(binary.charAt(i) == '1') cardinality++;
		}
		return cardinality;
	}
	
	private static int[] cardinalitySort2(int[] nums) {
		Integer[] numsArray = new Integer[nums.length];
		
		for(int i=0; i<numsArray.length; i++) {
			numsArray[i] = nums[i];
		}
		Arrays.sort(numsArray, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(getCardinality2((int)o1) == getCardinality2((int)o2)) return o1 - o2;
				else return getCardinality2((int)o1) - getCardinality2((int)o2);
			}
		});
		
		for(int i=0; i<nums.length; i++) {
			nums[i] = numsArray[i];
		}
		
		return nums;
	}
	
	private static int getCardinality2(int num) {
		int cardinality = 1;
		while(num != 0) {
			if(num%2 == 1) cardinality++;
			num /= 2;
		}		
		return cardinality;
	}

}
