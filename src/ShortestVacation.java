import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ShortestVacation {

	public static void main(String[] args) {
//		int[] A = { 7, 5, 2, 7, 2, 7, 4, 7 };
//		int[] A = {1,1,1,1,1,1,1,2};
		int[] A = {1,2,2,3,2,1};
//		int[] A = { 2, 1, 1, 3, 2, 1, 1, 3 };
		ShortestVacation lr = new ShortestVacation();
		System.out.println(lr.solution(A));
	}

	public int solution1(int[] A) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			if (!map.containsKey(A[i]))
				map.put(A[i], 1);
		}

		int start = 0, end = 0, counter = map.size(), minStart = 0, minLen = A.length;
		int size = A.length;
		while (end < size) {
			if (map.containsKey(A[end]) && map.get(A[end]) > 0)
				counter--;
			map.put(A[end], map.get(A[end]) - 1);
			end++;

			while (counter == 0) {
				if (end - start < minLen) {
					minStart = start;
					minLen = end - start;
				}
				map.put(A[start], map.get(A[start]) + 1);
				if (map.containsKey(A[start]) && map.get(A[start]) > 0) {
					counter++;
				}
				start++;
			}
		}

		return minLen - minStart + 1;
	}

	public int solution2(int[] A) {
		Set<Integer> locations = new HashSet<>();
		for (int i = 0; i < A.length; i++)
			locations.add(A[i]);

		Set<Integer> loc = new HashSet<>();

		int window = locations.size(), counter = 0;
		while (window < A.length) {
			for (int i = 0; i < A.length - window; i++) {
				loc.addAll(locations);
				counter = 0;
				for (int j = i; j < i + window; j++) {
					if (loc.contains(A[j])) {
						loc.remove(A[j]);
						++counter;
					}
				}
				if (counter == locations.size()) return window;
			}
			window++;
		}
		return window;
	}

	public int solution(int[] A) {
        HashSet<Integer> locations = new HashSet<>();
        
        for(int i=0;i<A.length;i++) {
        	locations.add(A[i]);
        }
        
        HashSet<Integer> locationList = locations;
        ArrayList<Integer> temp = new ArrayList<>();
        
        int tripLength = 0;
        
        for(int i=0; i<A.length; i++) {
        	   if(temp.contains(A[i])) {
        		   while(!temp.isEmpty() && temp.get(0) == A[i]) temp.remove(0);
        		   
        		   temp.add(A[i]);
        		   locations.removeAll(temp);
        		   
        		   if(locations.isEmpty()) {
        			   if(tripLength == 0) tripLength = temp.size();
        			   else if (temp.size() < tripLength) tripLength = temp.size();
        			   locations = locationList;
        		   }
        	   }else {        		   
        		   temp.add(A[i]);
        		   locations.removeAll(temp);
        		   
        		   if(locations.isEmpty()) {
        			   if(tripLength == 0) tripLength = temp.size();
         			   else if (temp.size() < tripLength) tripLength = temp.size();
        			   locations = locationList;
        		   }
        	   }
        }
        return tripLength;
	}
}
