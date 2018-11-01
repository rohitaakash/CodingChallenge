
public class SingleElementSortedArray {

	public int singleNonDuplicate(int[] nums) {
		
		return find(0, nums.length-1, nums);

	}
	
	public int find(int start, int end, int[] nums) {
		
		if(start<end) {
			int mid = start + (end - start + 1)/2;
			if(nums[mid] == nums[mid+1]) {
				if(mid%2==0) return find(mid+1, end, nums);
				else return find(start, mid-1, nums);
			}else if(nums[mid] == nums[mid-1]) {
				if(mid%2 == 0) return find(start, mid, nums);
				else return find(mid+1, end, nums);			
			}else {
				return nums[mid];
			}
		}else {
			return nums[start];
		}
		
		
	}

	public static void main(String[] args) {
		int[] nums1 = {1,1,2,3,3,4,4,8,8};
		int[] nums2 = {1,1,2};
		int[] nums3 = {3,3,7,7,10,11,11};
		
		SingleElementSortedArray send = new SingleElementSortedArray();
		
		System.out.println(send.singleNonDuplicate(nums1));
		System.out.println(send.singleNonDuplicate(nums2));
		System.out.println(send.singleNonDuplicate(nums3));
	}
}
