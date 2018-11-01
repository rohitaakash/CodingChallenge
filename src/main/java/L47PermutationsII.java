import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L47PermutationsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		System.out.println(permuteUnique(nums));

	}

	public static int permuteUnique(int[] nums) {

		List<List<Integer>> output = new ArrayList<>();
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums.length; j++) {
				Integer[] numsCopy = Arrays.stream(nums).boxed().toArray(Integer[]::new);
				int temp = numsCopy[i];
				numsCopy[i] = numsCopy[j];
				numsCopy[j] = temp;
				List<Integer> newList = Arrays.asList(numsCopy);
				System.out.println(newList);
				if(!output.contains(newList)) {
					output.add(newList);
				}
						
			}
		}
		return output.size();
	}

	public static int permuteUnique2(int[] nums) {

		List<List<Integer>> output = new ArrayList<>();
		List<Integer> numsList = new ArrayList<>();
		for(int i=0; i<nums.length; i++) {
			numsList.add(nums[i]);
		}
		
		for(int i=0; i<nums.length; i++) {
			
		}
		return output.size();
	}
	
	public static List<Integer> permuteUniqueHelper(List<Integer> numsList, int start, List<List<Integer>> output) {
		List<Integer> temp = new ArrayList<>();
		
		
		return temp;
	}
	
}
