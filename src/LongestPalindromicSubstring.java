
public class LongestPalindromicSubstring {
	public static String longestPalindrome(String s) {

		int start = 0, end = 0;

		for (int i = 0; i < s.length(); i++) {
			int l1 = getLargestPalindrome(s, i, i);
			int l2 = getLargestPalindrome(s, i, i + 1);

			int l = Math.max(l1, l2);

			if (l > (end - start + 1)) {
				start = i - (l - 1) / 2;
				end = i + l / 2;
			}

		}
		return s.substring(start, end + 1);

	}

	private static int getLargestPalindrome(String s, int start, int end) {

		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}

		return end - start - 1;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("abbabba"));
	}
}
