
public class PasswordSubstring {

	public static void main(String[] args) {
		String S = "99999999a";
		System.out.println(solution(S));
	}

	public static int solution(String S) {
		
		int max = -1; 
		String[] split = S.split("[0-9]+");
		for(String str: split) {
			int size = sizePassword(str);
			if(size > max) max = size;
		}
		
		return max;
	}
	
	public static int sizePassword(String str) {
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)>='A' && str.charAt(i)<='Z') return str.length();
		}
		return -1;
	}
	
	
}
