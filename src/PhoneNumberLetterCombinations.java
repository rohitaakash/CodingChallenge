import java.util.ArrayList;
import java.util.List;

public class PhoneNumberLetterCombinations {

	public static void main(String[] args) {
		List<String> output = letterCombinations("23");
		System.out.println(output);
	}
	
	public static List<String> letterCombinations(String digits) {
		List<String> output = new ArrayList<>();
		String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
		if(digits.equals("") || digits == null){
            return output;
        }
		
		createCombination("", digits, 1, letters, output);
		
        return output;
    }
	
	public static void createCombination(String curr, String digits, int pos, String[] letters, List<String> output) {
		int num = digits.charAt(pos-1) - '0';
		if(pos == digits.length()) {
			for(int i=0; i<letters[num-2].length(); i++) {
				output.add(curr+letters[num-2].charAt(i));
			}
		} else {
			for(int i=0; i<letters[num-2].length(); i++) {
				createCombination(curr+letters[num-2].charAt(i), digits, pos+1, letters, output);
			}
			
		}
		
	}
}
