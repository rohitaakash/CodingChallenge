
public class StringBuildDash {

	public static void main(String[] args) {
		System.out.println(convert("24-A0r74k", 2));
	}
	
	public static String convert(String s, int k) {
		
		int l = s.length();
		int n = s.replaceAll("-", "").length();
		int first = n%(k+1);
		System.out.println(first);
		StringBuilder sb = new StringBuilder();
		
		int start = 0;
		while(sb.length()!=l) {
			
			for(int i = 0; i < first;) {
				if(s.charAt(start)!='-') {
					sb.append(s.charAt(start));
					i++;
				}
				start++;
			}
			
			if (sb.length()!=l) {
				sb.append('-');
			}
			
			first = k;
		}
		return sb.toString();
	}
	
	public static String longestCommonPrefix(String[] a) {
		
		return "";
	}
}
