import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeMap;


class PairActivityAndCount implements Comparable<PairActivityAndCount>{
	String activity;
	int count;
	
	public PairActivityAndCount(String a,int b) {
		activity=a;
		count=b;
	}

	@Override
	public int compareTo(PairActivityAndCount o) {
		
		return activity.compareTo(o.activity);
	}
}

public class Solution {   

	public static boolean compareActivity(PairActivityAndCount p1,PairActivityAndCount p2) {

		if(p1.activity.equals(p2.activity))
			return true;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		String[] range=sc.nextLine().split(",\\s*");
		Arrays.sort(range);

		sc.nextLine();

		TreeMap<String, ArrayList<PairActivityAndCount>> map=new TreeMap<>(Collections.reverseOrder());

		String[] input = null;
		while(sc.hasNextLine()){
            String line = sc.nextLine();
            if(line.equals("")){
               break;
            }
			input=line.split(",\\s*");
			input[0]=input[0].substring(0, 7);
            if(input[0].compareTo(range[0]) >= 0 && input[0].compareTo(range[1]) <= 0){
                if(!map.containsKey(input[0])){
				    ArrayList<PairActivityAndCount> arr=new ArrayList<>();
				    arr.add(new PairActivityAndCount(input[1], Integer.parseInt(input[2])));
				    map.put(input[0], arr);
			     }
			     else{
				    boolean isAdded=false;
				    PairActivityAndCount p1=new PairActivityAndCount(input[1], Integer.parseInt(input[2]));
				    for(PairActivityAndCount p2: map.get(input[0])){
					   if(compareActivity(p1, p2)){
						  p2.count+=p1.count;
						  isAdded=true;
						  break;
					   }
				    }
				    if(!isAdded){
					   map.get(input[0]).add(p1);
				    }
			     }
            }
		}
		
		
		
		for(String s: map.keySet()){
			Collections.sort(map.get(s));
            System.out.print(s + ", ");
            
            for(int i=0; i<map.get(s).size(); i++){
                PairActivityAndCount p = map.get(s).get(i);
                System.out.print(p.activity + ", " + p.count);
                if(i != map.get(s).size()-1){
                    System.out.print(", ");
                }
            }
            
            System.out.println();
		}
		
		sc.close();
 		

	}

}