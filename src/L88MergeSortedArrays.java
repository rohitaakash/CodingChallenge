
public class L88MergeSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {4,5,6,0,0,0};
		int[] nums2 = {1,2,3};
		
		merge(nums1, 3, nums2, 3);
		
		System.out.println(nums2);
		for (int i = 0; i < nums1.length; i++) {
			System.out.println(nums1[i]);
		}

	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		if(m+n <= nums1.length) {
			int i=m-1, j=n-1, k=m+n-1;
			while(k>=0) {
				if(i >= 0 && j >= 0) {
					if(nums1[i] >= nums2[j]) {
						nums1[k] = nums1[i];
						i--;
					} else {
						nums1[k] = nums2[j];
						j--;
					}
				} else {
					if(j >= 0) {
						nums1[k] = nums2[j];
						j--;
					} else {
						nums1[k] = nums1[i];
						i--;
					}
				}
				k--;
			}
		}
		
	}

}
