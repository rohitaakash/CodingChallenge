import java.util.Stack;

public class L150EvaluateReversePolishNotation {
	public static void main(String[] args) {
		String[] tokens = { "4", "13", "5", "/", "+" };
		System.out.println(evalRPN(tokens));
	}

	public static int evalRPN(String[] tokens) {
		Stack<Integer> compute = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if (!(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/"))) {
				int token = Integer.parseInt(tokens[i]);
				compute.push(token);
			} else {
				int num1 = compute.pop();
				int num2 = compute.pop();
				int result = 0;
				if (tokens[i].equals("+"))
					result = num2 + num1;
				else if (tokens[i].equals("-"))
					result = num2 - num1;
				else if (tokens[i].equals("*"))
					result = num2 * num1;
				else
					result = num2 / num1;
				compute.push(result);
			}
		}
		return compute.pop();
	}

}
