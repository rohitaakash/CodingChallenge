import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class MergeIntervals {
	
	public static List<Interval> merge(List<Interval> intervals) {
		if (intervals.isEmpty())
			return intervals;

		List<Interval> merged = new ArrayList<>();
		Collections.sort(intervals, new StartComparator());
		HashMap<Integer, Integer> map = new HashMap<>();

		int current = intervals.get(0).start;
		map.put(intervals.get(0).start, intervals.get(0).end);

		for (int i = 1; i < intervals.size(); i++) {
			if((map.containsKey(intervals.get(i).start) && map.get(intervals.get(i).start) <= intervals.get(i).end)
					|| (map.get(current) >= intervals.get(i).start) && map.get(current) <= intervals.get(i).end) {
				map.put(current, intervals.get(i).end);
			}else if(map.get(current)< intervals.get(i).start) {
				map.put(intervals.get(i).start, intervals.get(i).end);
				current = intervals.get(i).start;
			}
		}

		for (int i : map.keySet()) {
			Interval k = new Interval(i, map.get(i));
			merged.add(k);
		}
		return merged;

	}

	
	public List<Interval> merge2(List<Interval> intervals) {
		List<Interval> merged = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();

		for (Interval i : intervals) {
			if (!map.containsKey(getStart(intervals, i.start)))
				map.put(getStart(intervals, i.start), getEnd(intervals, i.end));
		}

		for (int i : map.keySet()) {
			Interval j = new Interval(i, map.get(i));
			merged.add(j);
		}
		return merged;
	}

	public int getStart(List<Interval> intervals, int start) {
		int s = start;
		for (Interval i : intervals) {
			if (i.start < start && i.end >= start) {
				s = getStart(intervals, i.start);
			}
		}
		return s;
	}

	public int getEnd(List<Interval> intervals, int end) {
		int e = end;
		for (Interval i : intervals) {
			if (i.start <= end && i.end > end) {
				e = getEnd(intervals, i.end);
			}
		}
		return e;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(0, 4));
		// intervals.add(new Interval(8,10));
		// intervals.add(new Interval(15,18));

		List<Interval> result = merge(intervals);

		for (Interval i : result) {
			System.out.println(i.start + "," + i.end);
		}
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

class StartComparator implements Comparator<Interval> {

	@Override
	public int compare(Interval o1, Interval o2) {
		// TODO Auto-generated method stub
		if (o1.start < o2.start)
			return -1;
		if (o1.start > o2.start)
			return 1;
		return 0;
	}

}
