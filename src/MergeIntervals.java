import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MergeIntervals {
	
	public List<Interval> merge(List<Interval> intervals){
        int[][] arr = new int[intervals.size()][2];
        
        int j = 0;
        for(Interval i: intervals){
            arr[j][0] = i.start;
            arr[j][1] = i.end;
        }
        
        Arrays.sort(arr);
        
        
        
        return null;
    }
	
	public List<Interval> merge2(List<Interval> intervals) {
        List<Interval> merged = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(Interval i: intervals){
            if(!map.containsKey(getStart(intervals, i.start))) map.put(getStart(intervals, i.start), getEnd(intervals, i.end));            
        }
        
        for(int i: map.keySet()){
            Interval j = new Interval(i, map.get(i));
            merged.add(j);
        }
        return merged;
    }

	public int getStart(List<Interval> intervals, int start) {
		int s = start;
		for(Interval i: intervals){
            if(i.start < start && i.end >= start){
                s = getStart(intervals, i.start);
            }
        }
		return s;
	}

	public int getEnd(List<Interval> intervals, int end) {
		int e = end;
		for(Interval i: intervals){
            if(i.start <= end && i.end > end){
                e = getEnd(intervals, i.end);
            }
        }
		return e;
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
