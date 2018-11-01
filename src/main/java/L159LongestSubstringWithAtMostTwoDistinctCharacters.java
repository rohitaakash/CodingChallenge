import java.util.HashSet;
import java.util.Set;

public class L159LongestSubstringWithAtMostTwoDistinctCharacters {

    public static void main(String[] args) {
        String s = "ccaabbaaaaaa";
        System.out.println(longestSubstringOptimized(s));
    }

    private static int longestSubstringOptimized(String s) {

        if (s.length() < 2) return s.length();

        int minIndex = 0, maxIndex = 1, prevIndex = 0, currIndex = 1, currMin = 0, currMax;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        set.add(s.charAt(1));

        for (int i = 2; i < s.length(); i++) {

            if (set.contains(s.charAt(i))) {
                if (s.charAt(i) != s.charAt(currIndex)) {
                    prevIndex = currIndex;
                }
            } else {
                if (set.size() == 2) {
                    set.remove(s.charAt(prevIndex));
                    currMin = prevIndex + 1;
                }
                set.add(s.charAt(i));
                prevIndex = currIndex;
            }

            currMax = i;
            currIndex = i;

            if (currMax - currMin + 1 > maxIndex - minIndex + 1) {
                minIndex = currMin;
                maxIndex = currMax;
            }

        }
        return maxIndex - minIndex + 1;
    }


}
