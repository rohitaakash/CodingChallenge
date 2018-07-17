
public class L33SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = {4,5,6,7,0,1,2};
//		System.out.println(search(nums, 0));
		int[] nums = { 5,1,2,3,4 };
		System.out.println(search(nums, 4));

	}

	public static int search(int[] nums, int target) {

		if (nums.length == 0)
			return -1;
		return binarySearch(nums, 0, nums.length - 1, target);
	}

	public static int binarySearch(int[] nums, int start, int end, int target) {

		int mid = (start + end) / 2;
		if (start == end && nums[start] != target)
			return -1;

		if(nums[mid] == target) return mid;
		
		int left = -1, right = -1;
		
		if(mid > start) left = binarySearch(nums, start, mid-1, target);
		if(mid < end) right = binarySearch(nums, mid+1, end, target);
		
		if(left == -1 && right == -1) return -1;
		else
			if(left != -1) return left;
			else return right;
	}

}
