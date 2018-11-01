import java.util.HashMap;
import java.util.Map;

public class ElectionWinner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] votes = {"Rohit", "John", "Example", "Ron", "Rohit", "John", "Ron"};
		System.out.println(electionWinner(votes));

	}
	
	public static String electionWinner(String[] votes) {
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<votes.length;i++) {
			if(map.containsKey(votes[i])) {
				map.put(votes[i], map.get(votes[i])+1);
			}else {
				map.put(votes[i], 1);
			}
		}
		
		int maxVotes = 0;
		String winner = "";
		for(String s: map.keySet()) {
			if(map.get(s) > maxVotes) {
					winner = s;
					maxVotes = map.get(s);
			}else if(map.get(s) == maxVotes) {
				if(winner.compareTo(s) > 0) {
					winner = s;
				}
			}
		}
		return winner;
	}
	
}
