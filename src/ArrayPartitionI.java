import java.util.Arrays;

public class ArrayPartitionI {

	public static void main(String[] args) {
		int[] nums = {1,4,3,2};
		
		ArrayPartitionI api = new ArrayPartitionI();
		System.out.println(api.arrayPairSum(nums));
	}

	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i=i+2) {
			sum += nums[i];
		}

		return sum;
	}
}
