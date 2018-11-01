public class ReverseAlgebraicExpression {

    public static void main(String[] args) {
        String expression = "300+200-100";
        System.out.println(reverse(expression));
    }

    private static String reverse(String expression){
        String ans = "";
        char c;
        int start = 0;
        boolean skip = false;

        for (int i = 0; i < expression.length(); i++) {
            c = expression.charAt(i);
            if ((c == '+' || c == '-' || c == '*' || c == '/') && i != 0 && !skip) {

                ans = c + expression.substring(start, i) + ans;
                c = expression.charAt(i + 1);
                if (c == '+' || c == '-' || c == '*' || c == '/') {
                    skip = !skip;
                }
                start = i + 1;
                continue;
            }
            if (skip)
                skip = !skip;

        }
        ans = expression.substring(start, expression.length()) + ans;
        return ans;
    }
}
