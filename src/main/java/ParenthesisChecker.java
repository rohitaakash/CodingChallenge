import java.util.Stack;

public class ParenthesisChecker {
	
	public static void main(String[] args) {
		System.out.println(check("{([)]}"));
		
	}
	
	public static boolean check(String s) {
		
		if(s.length()%2 != 0) return false;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				stack.add(s.charAt(i));
			}else {
				if(s.charAt(i) == ')' && stack.peek() == '(' 
						|| s.charAt(i) == '}' && stack.peek() == '{' 
						|| s.charAt(i) == ']' && stack.peek() == '[') {
					stack.pop();
				}else {
					return false;
				}
			}
		}
		if(stack.isEmpty()) {
			return true;
		}
		
		return false;
	}

}
