import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LogHistory {

	static int check_log_history(String[] events) {
		
		Set<String> set = new HashSet<>();
		Stack<String> stack = new Stack<>();
		int i;
		for(i=0; i<events.length; i++) {
			String[] parts = events[i].split("\\s");
			if(parts[0].equals("ACQUIRE")) {
				if(set.contains(parts[1])) {
					return i+1;
				}else {
					stack.push(events[i]);
					set.add(parts[1]);
				}
			}else if(!stack.isEmpty()){
				String[] peek = stack.peek().split("\\s");
				if(peek[0].equals("ACQUIRE") && peek[1].equals(parts[1])) {
					stack.pop();
					set.remove(parts[1]);
				}else {
					return i+1;
				}
			}
		}
		return stack.isEmpty() ? 0 : i;

	}

	public static void main(String[] args) {
		String[] events = { "ACQUIRE 364", "ACQUIRE 364", "ACQUIRE 84", "RELEASE 84" };
		System.out.println(check_log_history(events));
	}
}
