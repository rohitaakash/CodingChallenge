public class L482LicenseKeyFormatting {

    public static void main(String[] args) {
        String S= "--a-a-a-a--";
        System.out.println(licenseKeyFormatting(S, 2));
    }

    private static String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();

        for (int i = S.length() - 1, j = 0; i >= 0; i--) {
            if (S.charAt(i) == '-') continue;
            if (j != 0 && j % K == 0 ) sb.append('-');
            sb.append(S.charAt(i));
            j++;
        }

        return sb.reverse().toString().toUpperCase();
    }
}
