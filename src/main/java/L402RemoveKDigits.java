public class L402RemoveKDigits {

    public static void main(String[] args) {
        String num = "11";
        System.out.println(removeKDigits(num, 1));
    }

    private static String removeKDigits(String num, int k) {
        if (num.length() <= k) return "0";

        StringBuilder sb = new StringBuilder();
        sb.append(num);
        for (int i = 0; i < sb.length() - 1 && k > 0; ) {
            if (sb.charAt(i) > sb.charAt(i + 1)) {
                sb.replace(i, i + 1, "");
                if (i != 0) i--;
                k--;
            } else if (sb.charAt(i) < sb.charAt(i + 1)) {
                while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
                    i++;
                }
                sb.replace(i, i + 1, "");
                if (i != 0) i--;
                k--;
            } else {
                i++;
            }
        }

        if(k>0) {
            sb.replace(sb.length() - k, sb.length(), "");
        }

        for(int i=0; i<sb.length(); ) {
            if(sb.charAt(i)=='0'){
                sb.replace(i, i+1, "");
            }else{
                break;
            }
        }

        if(sb.length() == 0) {
            return "0";
        }

        return sb.toString();
    }
}
