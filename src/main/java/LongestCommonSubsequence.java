
public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String a = "ABCDEFGHIJKLM", b = "NOPQRSTUVWXYZ";
		
		long start, end;
		
		start = System.currentTimeMillis();
		System.out.println(lcsTopDown(a, b));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		start = System.currentTimeMillis();
		System.out.println(lcsBottomUp(a, b));
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		start = System.currentTimeMillis();
		System.out.println(lcsRecursive(a, b));
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	public static int lcsTopDown(String a, String b) {
		
		int[][] cache = new int[a.length()][b.length()];
		
		for(int i=0; i<a.length(); i++) {
			for(int j=0; j<b.length(); j++) {
				cache[i][j] = -1;
			}
		}
		
		return lcsTopDownHelper(a, b, a.length()-1, b.length()-1, cache);
	}
	
	private static int lcsTopDownHelper(String a, String b, int endA, int endB, int[][] cache) {
		if(endA < 0 || endB < 0) return 0;
		
		if(cache[endA][endB] != -1) return cache[endA][endB];
		if(a.charAt(endA) == b.charAt(endB)) cache[endA][endB] =  1 + lcsTopDownHelper(a, b, endA-1, endB-1, cache);
		else cache[endA][endB] =  Math.max(lcsTopDownHelper(a, b, endA, endB-1, cache), lcsTopDownHelper(a, b, endA-1, endB, cache));
		
		return cache[endA][endB];
	}
	
	public static int lcsBottomUp(String a, String b) {
		
		int[][] cache = new int[a.length()+1][b.length()+1];
		for (int i = 0; i < cache.length; i++) {
			for (int j = 0; j < cache[i].length; j++) {
				if(i == 0 || j==0) cache[i][j] = 0;
				else {
					if(a.charAt(i-1) == b.charAt(j-1)) cache[i][j] = 1 + cache[i-1][j-1];
					else cache[i][j] = Math.max(cache[i][j-1], cache[i-1][j]);
				}
			}
		}
		return cache[a.length()][b.length()];
	}
	
	public static int lcsRecursive(String a, String b) {
		return lcsRecursiveHelper(a, b, a.length()-1, b.length()-1);
	}

	private static int lcsRecursiveHelper(String a, String b, int endA, int endB) {
		if(endA < 0 || endB < 0) return 0;
		
		if(a.charAt(endA) == b.charAt(endB)) return 1 + lcsRecursiveHelper(a, b, endA-1, endB-1);
		else return  Math.max(lcsRecursiveHelper(a, b, endA, endB-1), lcsRecursiveHelper(a, b, endA-1, endB));
		
	}
	
}
