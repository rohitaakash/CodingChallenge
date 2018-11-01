
public class ArrayProduct {
	
	public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        
        output[0] = 1;
        for (int i = 1; i < output.length; i++) {
			output[i] = output[i-1] * nums[i-1];
		}
        
        int p = 1;
        for(int i=nums.length-1; i>=0; i--){
            output[i] = output[i]*p;
            p = p*nums[i];
        }
        
        return output;
    }

	public static void main(String[] args) {
		ArrayProduct ap = new ArrayProduct();
		
		int[] nums = {1,2,3,4};
		int[] output = ap.productExceptSelf(nums);
		
		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
		
	}
}
