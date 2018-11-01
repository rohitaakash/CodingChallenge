import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RepeatingCharacter {
	public static void main(String args[]) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int[] charCount = new int[256];
		for (int i = 0; i < s.length(); i++) {
			charCount[s.charAt(i)] = charCount[s.charAt(i)] + 1;
		}
		

		for(int i=0; i<s.length(); i++) {
			if(charCount[s.charAt(i)] > 1) {
				System.out.println(s.charAt(i));
				return;
			}
		}
	}
}