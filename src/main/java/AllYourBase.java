import java.util.HashMap;

public class AllYourBase {

	public static void main(String[] args) {
		System.out.println(computeWarTime("cats"));
		System.out.println(computeWarTime("11001001"));
		System.out.println(computeWarTime("ab2ac999"));
		
	}
	
	public static String computeWarTime(String symbol) {
		HashMap<Character, Integer> map = new HashMap<>();
		
		if(symbol.length() == 0) return 0 + "";
		
		int counter = 2;
		for(int i=0; i<symbol.length(); i++) {
			if(!map.containsKey(symbol.charAt(i))) {
				if(map.size() == 0) map.put(symbol.charAt(i), 1);
				else if(map.size() == 1) map.put(symbol.charAt(i), 0);
				else{
					map.put(symbol.charAt(i), counter);
					counter++;
				}
			}
		}
		
		int num = 0;
		for(int i=0; i<symbol.length(); i++) {
			num = num*10 + map.get(symbol.charAt(i));
		}
		
		int dec = 0, exp=0;
		while(num!=0) {
			dec = (int) (dec + num%10*Math.pow(map.size(), exp));
			num = num/10;
			exp++;
		}
		
		return dec + "";
	}
}
