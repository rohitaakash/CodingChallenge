import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class RomanNumeralNameSorting {

	public static int returnIntFromRoman(String str) {
		
		TreeMap<Character, Integer> map = new TreeMap<>();
		
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        
        int res = 0;
        
        for (int i=0; i<str.length(); i++)
        {
            int s1 = map.get(str.charAt(i));
            if (i+1 <str.length())
            {
                int s2 = map.get(str.charAt(i+1));
                if (s1 >= s2) res = res + s1;
                else {
                    res = res + s2 - s1;
                    i++; 
                }
            }
            else
            {
                res = res + s1;
                i++;
            }
        }
        return res;
	}
	
	public String[] getOrdering(String[] names) {
		Arrays.sort(names, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				String[] str1 = s1.split("\\s");
				String[] str2 = s2.split("\\s");
				
				if(str1[0].compareTo(str2[0]) == 0) {
					return (returnIntFromRoman(str1[1]) - returnIntFromRoman(str2[1]));
				}
				return str1[0].compareTo(str2[0]);
			}

		});
		
		return names;
	}
	
	public static void main(String[] args) {
		String[] names = {"Philip Coehl II", "Phillippe I", "Rohit XV", "Rohit XIV","Ujjawal III", "Aakash IV"};
		
		RomanNumeralNameSorting rns = new RomanNumeralNameSorting();
		rns.getOrdering(names);
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}
}
