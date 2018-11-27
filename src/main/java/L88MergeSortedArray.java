public class L88MergeSortedArray {

    public static void main(String[] args) {
//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,5,6};
//        merge(nums1, 3, nums2  , 3);
//        printArray(nums1);

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2  , 3);
        printArray(nums1);

    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int ind1 = m-1, ind2=n-1;
        for(int i=nums1.length-1; i>=0; i--) {
            if(ind1 >=0 && ind2>=0) {
                if(nums1[ind1] < nums2[ind2]) {
                    nums1[i] = nums2[ind2];
                    ind2--;
                }else{
                    nums1[i] = nums1[ind1];
                    ind1--;
                }
            }else {
                if(ind2 >= 0) {
                    for(int j=ind2; j>=0; j--,i--) {
                        nums1[i] = nums2[j];
                    }
                }
            }
        }
    }

    private static void printArray(int[] nums) {
        for (int i=0; i<nums.length; i++){
            System.out.print(nums[i]);
            if(i <nums.length-1) System.out.print(", ");
        }
    }
}
