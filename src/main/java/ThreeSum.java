import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();

		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if(i==0 || (i > 0 && nums[i] != nums[i-1])) {
				int j = i + 1, k = nums.length - 1, sum = -nums[i];
				while(j<k){
					if (nums[k] + nums[j] == sum) {
						list.add(Arrays.asList(nums[i], nums[j], nums[k]));
						while(j<k && nums[j] == nums[j+1]) j++;
	                    while(j<k && nums[k] == nums[k-1]) k--;
	                    j++;
	                    k--;
					}else if(nums[j] + nums[k] < sum){
	                    j++;
	                }else{
	                    k--;
	                }
				}
			}
			
		}
		return list;
	}

	public static void main(String[] args) {

		int[] nums = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> list = threeSum(nums);

		for (List<Integer> v : list) {
			for (int i = 0; i < v.size(); i++) {
				System.out.print(v.get(i) + ",");
			}
			System.out.println();
		}

	}
}
