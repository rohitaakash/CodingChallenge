
public class LongestPalindromicSequence {
	
	private static String s= "rohitaakash";

	public static void main(String[] args) {
		System.out.println(longestSequence(0, s.length()-1));
	}
	
	public static int longestSequence(int i, int j) {
		if(i == j) return 1;
		if(s.charAt(i) == s.charAt(j)) {
			if(i+1 == j) return 2;
			else return 2 + longestSequence(i+1, j-1);
		}else {
			return Math.max(longestSequence(i+1, j), longestSequence(i, j-1));
		}		
	}
}
