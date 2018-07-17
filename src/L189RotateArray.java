
public class L189RotateArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,-100,3,99};
		rotate(nums, 2);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

	public static void rotate(int[] nums, int k) {
		k = k%nums.length;
		int[] temp = new int[k];
		for(int i=0; i<k; i++) {
			temp[i] = nums[nums.length-i-1];
		}
		
		for(int i=nums.length-1; i>=k; i--) {
			nums[i] = nums[i-k];
		}
		
		for(int i=0; i<temp.length; i++) {
			nums[k-i-1] = temp[i];
		}
	}

}
