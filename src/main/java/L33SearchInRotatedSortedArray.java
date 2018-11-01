public class L33SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 4,5,6,7,0,1,2 };
		System.out.println(search(nums, 0));
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
		
		if(nums[mid] > nums[start]) {
			if(target < nums[mid] && target >= nums[start])
				return binarySearch(nums, start, mid-1, target);
			else return binarySearch(nums, mid+1, end, target);
		}else {
			if(target > nums[mid] && target <= nums[end])
				return binarySearch(nums, mid+1, end, target);
			else return binarySearch(nums, start, mid-1, target);
		}
		
	}

}
