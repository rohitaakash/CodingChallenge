public class CheckPalindrome {
	public static void main(String[] args) {

		// String str = "a man,(nama";
		// String str = "eme,eme";
		String str = "emedme";
		System.out.println(checkPalindrome2(str));

	}

	public static boolean checkPalindrome(String str) {
		int i = 0, j = str.length() - 1;

		while (i < j) {
			if (!((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'))) {
				i++;
				continue;
			}
			if (!((str.charAt(j) >= 'A' && str.charAt(j) <= 'Z') || (str.charAt(j) >= 'a' && str.charAt(j) <= 'z'))) {
				j--;
				continue;
			}

			if (str.charAt(i) != str.charAt(j))
				return false;
			else {
				i++;
				j--;
			}
		}
		return true;
	}

	public static int checkPalindrome2(String str) {
		int lindex = -1, rindex = -1;
		int i = 0, j = str.length() - 1;

		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				lindex = i;
				rindex = j;
				break;
			} else {
				i++;
				j--;
			}
		}

		String lstring = str.substring(0, rindex) + str.substring(rindex + 1, str.length());

		String rstring = str.substring(0, lindex) + str.substring(lindex + 1, str.length());
		if (checkPalindrome(rstring))
			return lindex;
		if (checkPalindrome(lstring))
			return rindex;

		return -2;
	}

}
