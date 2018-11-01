import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TimeMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char[] message = {'>','>','<', '<','>','>','*','>','<'};
//		char[] message = {'>','>','>','*', '>','*','<','*','>','>'};
//		System.out.println(computeMagicalYear(message));
		
		String msg = ">*>>><<<<<*****>>>**<<<";
		
		
		System.out.println(computeMagicalYear(msg));

	}

	public static int computeMagicalYear(char[] message) {
		int multiplier = 1, pos = message.length, total = 0;
		
		for (int i = message.length - 1; i >= 0; i--) {
			if(message[i] == '*') {
				multiplier *= 2;
				pos = i-2;
			}else {
				if(i == pos) {
					if(message[i] == '<') total += -1*multiplier;
					else total += 1*multiplier;
					
					multiplier = 1;
				}else {
					if(message[i] == '<') total += -1;
					else total += 1;
				}
				
			}
		}
		return 2017 + total;
	}
	
	public static int computeMagicalYear(String msg) {
		Queue<List<Integer>> queue = new LinkedList<>();
		List<Integer> list;
		int total = 0;
		
		for(int i=msg.length()-1; i>=0; i--) {
			list = new ArrayList<>();
			if(!queue.isEmpty() && queue.peek().get(0) == i) {
				if(msg.charAt(i) == '*') {
					list.add(i-2);
					list.add(queue.peek().get(1)*2);
					queue.add(list);
				}else {
					if(msg.charAt(i) == '<') total += -1 * queue.peek().get(1);
					else total += 1 * queue.peek().get(1);
				}
				queue.poll();
			}else {
				if(msg.charAt(i) == '*') {
					list.add(i-2);
					list.add(2);
					queue.add(list);
				}else {
					if(msg.charAt(i) == '<') total += -1;
					else total += 1;
				}
			}
		}
		return 2017 + total;
	}

}
