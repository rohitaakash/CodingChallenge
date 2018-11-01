
public class StringToInteger {

	public static int myAtoi(String str) {

		int num = 0, i = 0;
		str = str.trim();
        
		if (str.length() == 0) return 0;
        
        char start = str.charAt(0);
        
		if (!(start == '+' || start == '-' || start >= '0' && start <= '9')) return 0;
		if (start == '+' || start == '-') i = 1;

		while(i < str.length()) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				if (num > Integer.MAX_VALUE / 10 || num == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)
					return (start == '-') ? Integer.MIN_VALUE : Integer.MAX_VALUE;

				num = num * 10 + str.charAt(i) - '0';
			} else {
				break;
			}

            i++;
		}

		if (start == '-') num = num * -1;

		return num;
	}

	public static void main(String[] args) {
		System.out.println(myAtoi("-2147483647"));
	}

}
