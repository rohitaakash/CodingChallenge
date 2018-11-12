public class L686RepeatedStringMatch {
    public static void main(String[] args) {
        String A ="abcd", B="cdabcdab";
//        String A ="abc", B="cabcabca";

        System.out.println(repeatedStringMatch(A, B));
    }

    public static int repeatedStringMatch(String A, String B) {

        int q = 1;
        StringBuilder S = new StringBuilder(A);
        for (; S.length() < B.length(); q++) S.append(A);
        if (S.indexOf(B) >= 0) return q;
        if (S.append(A).indexOf(B) >= 0) return q+1;
        return -1;
    }
}
