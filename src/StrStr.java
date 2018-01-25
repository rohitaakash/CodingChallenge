
public class StrStr {

	public static void main(String[] args) {

		String haystack = "I am a good boy, not a good guy";
		String needle = "a";
		System.out.println(strStrImplementation(haystack, needle));

	}

	public static int strStrImplementation(String haystack, String needle) {

		int hLength = haystack.length();
		int nLength = needle.length();
		
		if (nLength > hLength) return -1;        
        if(nLength == 0) return 0;     
        
		
		for (int i = 0; i < hLength - nLength + 1; i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				int k = 1;
				for (int j = i + 1; j < nLength + i; j++, k++) {
					if (!(haystack.charAt(j) == needle.charAt(k))) {
						break;
					}
				}
				if (k == nLength)
					return i;
			}

		}
		return -1;
	}
}
