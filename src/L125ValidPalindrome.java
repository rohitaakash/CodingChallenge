
public class L125ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("0P"));

	}

	public static boolean isPalindrome(String s) {
		String str = s.toLowerCase();
		int start = 0, end = str.length() - 1;
		
		while (start < end) {
			if (!((str.charAt(start) >= 'a' && str.charAt(start) <= 'z')
					|| (str.charAt(start) >= '0' && str.charAt(start) <= '9'))
					|| !((str.charAt(end) >= 'a' && str.charAt(end) <= 'z')
							|| (str.charAt(end) >= '0' && str.charAt(end) <= '9'))) {
				if (!((str.charAt(start) >= 'a' && str.charAt(start) <= 'z')
						|| (str.charAt(start) >= '0' && str.charAt(start) <= '9')))
					start++;
				if (!((str.charAt(end) >= 'a' && str.charAt(end) <= 'z')
						|| (str.charAt(end) >= '0' && str.charAt(end) <= '9')))
					end--;
			} else {
				if (str.charAt(start) != str.charAt(end)) {
					return false;
				} else {
					start++;
					end--;
				}
			}
		}

		return true;
	}

}
