import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BracesMatching {

    public static void main(String[] args) {
        String[] values = {"{}[]()", "{[}]}"};
        List<String> output = Arrays.asList(braces(values));
        System.out.println(output);
    }

    private static String[] braces(String[] values) {
        String[] output = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            Stack<Character> stack = new Stack<>();
            String value = values[i];
            boolean flag = true;
            for (int j = 0; j < value.length(); j++) {
                char c = value.charAt(j);
                if (c == '}' || c == ']' || c == ')') {
                    if (!stack.isEmpty()) {
                        if (!((c == ')' && stack.peek() == '(') || (c == '}' && stack.peek() == '{') || (c == ']' && stack.peek() == '['))) {
                            flag = false;
                            break;
                        }else{
                            stack.pop();
                        }
                    }else {
                        flag = false;
                        break;
                    }
                }else{
                    stack.push(c);
                }
            }
            if(flag)
                output[i] = "YES";
            else
                output[i] = "NO";
        }
        return output;
    }
}
