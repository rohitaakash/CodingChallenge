import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MinimumPathTraversal {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = br.readLine();
		List<Integer> triangleRow = null;
		List<List<Integer>> triangle = new ArrayList<>();
		while(line != null) {
			String[] nums = line.trim().split("\\s+");
			triangleRow = new ArrayList<>();
			
			
			for(int i=0; i<nums.length; i++) {
				triangleRow.add(Integer.parseInt(nums[i]));
			}
			
			triangle.add(triangleRow);
			
			line = br.readLine();
		}
		
		br.close();
		
		System.out.println(shortestPath(triangle));
	}
	
	public static int shortestPath(List<List<Integer>> triangle) {
		
		for(int i=triangle.size()-2; i>=0; i--) {
			for(int j=0; j<triangle.get(i).size(); j++) {
				triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
			}
		}
		return triangle.get(0).get(0);
	}
	
	

}
