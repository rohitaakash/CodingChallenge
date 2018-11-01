
public class MedianSortedArrays {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;        
        int l = n+m;
        double mid;
        int[] merged = new int[l];
        
        for(int i=0, j=0, k=0; i<l; i++){
            
            if(j<n && k<m){
                if(nums1[j] <= nums2[k]){
                    merged[i] = nums1[j];
                    j++;
                }else{
                    merged[i] = nums2[k];
                    k++;
                }
            }else if(j < n){
                merged[i] = nums1[j];
                j++;
            }else{
                merged[i] = nums2[k];
                k++;
            }
        }
        
        if(l%2 == 0){
            mid = (merged[l/2] + merged[l/2 - 1])/2.0;
        }else{
            mid = merged[l/2];
        }
        
        return mid;
    }
	
	public static void main(String[] args) {
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
