import java.util.LinkedList;
import java.util.Queue;

public class MagicVowels {
	
	public static void main(String[] args) {
		
		String s1 = "aeiaaioooaauuaeiou";
		System.out.println(longestSubsequence(s1));
		
		String s2 = "aeiaaioooaa";
		System.out.println(longestSubsequence(s2));
		
		String s3 = "eouaeiaeiou";
		System.out.println(longestSubsequence(s3));
	}
	
	public static int longestSubsequence(String s) {
		if(s.length() == 0) return 0;
		char[] sequence = new char[s.length()];
		
		Queue<Character> queue = new LinkedList<>();
		queue.add('a');
		queue.add('e');
		queue.add('i');
		queue.add('o');
		queue.add('u');
		
		int last = -1;
		
		for(int i=0; i<s.length(); i++) {
			if( (last == -1) ? queue.peek() == s.charAt(i) : !queue.isEmpty() ? queue.peek() == s.charAt(i) || s.charAt(i) == sequence[last] : s.charAt(i) == sequence[last] ) {
				if(last == -1) {
					sequence[++last] = s.charAt(i);
					queue.poll();
				}else {
					if(s.charAt(i) > sequence[last]) {
						queue.poll();
					}
					sequence[++last] = s.charAt(i);
				}
				
			}else {
				if(binarySearch(sequence, 0, last, s.charAt(i)) != -1) 
					sequence[binarySearch(sequence, 0, last, s.charAt(i))] = s.charAt(i);
			}
		}
		return queue.isEmpty() ? last+1 : 0;
	}
	
	public static int binarySearch(char[] lis, int start, int end, int key) {
		if(start > end) return -1;
		int mid = (start + end)/2;
		
		if(start == end) return mid;
		if(lis[mid]<key) return binarySearch(lis, mid+1, end, key);
		else return binarySearch(lis, start, mid, key);
	}
}
