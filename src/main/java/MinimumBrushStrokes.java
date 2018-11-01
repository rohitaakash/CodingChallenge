
public class MinimumBrushStrokes {

	public int solution(int[] A) {
        // write your code in Java SE 8		
		int maxHeight = 0; 
		long brushStrokes = 0;
		
		//find the maximum height of the building
		for (int i = 0; i < A.length; i++) {
			if(A[i] > maxHeight) maxHeight = A[i];
		}
		
		//iteratively add the number of brushstrokes at each level
		for(int i=1; i<=maxHeight; i++) {
			brushStrokes += findConsecutiveSubsets(A, i);
			if(brushStrokes >= 1000000000) return -1;
		}
		
		return (int)brushStrokes;
		
	
    }

	public int findConsecutiveSubsets(int[] A, int level) {
		int subSets = 0;

		if (A[0] >= level)
			subSets = 1;
		
		//compute the number of disjoint subsets at each level
		for (int i = 1; i < A.length; i++) {
			if (A[i] >= level && A[i - 1] >= level) {
				continue;
			} else if (A[i] >= level) {
				subSets++;
			}
		}
		return subSets;
	}
	
	public static void main(String[] args) {
		int[] A = {1,3,2,1,2,1,5,3,3,4,2};
		MinimumBrushStrokes mbs = new MinimumBrushStrokes();
		
		System.out.println(mbs.solution(A));
	}
}
