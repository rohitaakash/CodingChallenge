import java.util.Stack;

public class BalancedExpression {
	
	public static void main(String[] args) {
		int expressions_size = 2;
//		String[] expressions = {"<>>>", "<>>>>"};
		String[] expressions = {"<>", "<>><"};
		int maxReplacements_size = 2;
//		int[] maxReplacements = {2,2};
		int[] maxReplacements = {1,0};
		int[] result_size = new int[maxReplacements_size];
		
		balancedOrNot(expressions_size, expressions, maxReplacements_size, maxReplacements, result_size);
		
		for (int i = 0; i < result_size.length; i++) {
			System.out.println(result_size[i]);
		}
	}
	
	public static int[] balancedOrNot(int expressions_size, String[] expressions, int maxReplacements_size, int[] maxReplacements, int[] result_size) {
		Stack<Character> expr = null;
		for (int i = 0; i < expressions.length; i++) {
			expr = new Stack<>();
			for(int j=0; j<expressions[i].length(); j++) {
				if(expressions[i].charAt(j) == '<') {
					expr.push('<');
				}else {
					if(expr.peek() == '<') expr.push('>');
					else {
						if(maxReplacements[i] != 0) {
							expr.push('<');
							expr.push('>');
							maxReplacements[i]--;
						}else {
							expr.push('<');
							break;
						}
					}
				}
			}
			result_size[i] = (expr.peek() == '<') ? 0 : 1;
		}
		return result_size;
	}
 
}
