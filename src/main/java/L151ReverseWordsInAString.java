
public class L151ReverseWordsInAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "the sky is blue ";
		System.out.println(reverseWords(input));
	}

	public static String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		int i = s.length()-1, k;
		
		while(i>=0 && s.charAt(i) == ' ') i--;
		System.out.println(i);
		for(int j=i; j>=0; j--) {
			System.out.println("j= " + j);
			for(k=j; k>=0 && s.charAt(k)!=' '; k--);
			System.out.println("k= " + k);
			if(k != j) {
				sb.append(s.substring(k+1, j+1));
				sb.append(' ');
				j=k+1;
			}
			
		}
		
		if(sb.toString().equals("")) return "";
		else return sb.deleteCharAt(sb.length()-1).toString();
	}

}
