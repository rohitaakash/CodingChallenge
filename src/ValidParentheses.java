import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		String s = "()[]{}";

		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid(s));
	}

	public boolean isValid(String s) {

		Stack<Character> paranthesesStack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				paranthesesStack.push(c);
			} else if (c == ')' || c == '}' || c == ']') {
				if (!paranthesesStack.isEmpty()) {
					char peek;
					if (c == ']')
						peek = '[';
					else if (c == '}')
						peek = '{';
					else
						peek = '(';
					if (paranthesesStack.peek() == peek) {
						paranthesesStack.pop();
					} else {
						return false;
					}

				} else {
					return false;
				}
			}
		}

		return paranthesesStack.isEmpty();
	}
}
