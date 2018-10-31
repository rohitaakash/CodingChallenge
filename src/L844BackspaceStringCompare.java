import java.util.Stack;

public class L844BackspaceStringCompare {

    public static void main(String[] args) {
//        String S = "ab#c", T = "ad#c";
//        String S = "ab##", T = "c#d#";
//        String S="a##c", T = "#a#c";
//        String S = "a#c", T = "b";
        String S = "y#fo##f", T = "y#f#o##f";
        System.out.println(backspaceCompare(S, T));
        System.out.println(backspaceCompareOptimized(S, T));
    }

    private static boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!sStack.isEmpty())
                    sStack.pop();

            } else {
                sStack.push(S.charAt(i));
            }
        }

        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!tStack.isEmpty())
                    tStack.pop();
            } else {
                tStack.push(T.charAt(i));
            }
        }

        System.out.println(sStack);
        System.out.println(tStack);

        if (sStack.size() != tStack.size()) return false;

        for (int i = 0; i < sStack.size(); i++) {
            if (sStack.pop() != tStack.pop())
                return false;
        }

        return true;
    }

    private static boolean backspaceCompareOptimized(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1, skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') { skipS++; i--; }
                else if (skipS > 0) { skipS--; i--; }
                else break;
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') { skipT++; j--; }
                else if (skipT > 0) { skipT--; j--; }
                else break;
            }

            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            else if (i >= 0 && !(j >= 0))
                return false;

            i--; j--;
        }

        return true;
    }


}
