import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ArrayDegree {
	
	public static void main(String[] args) {
		int[] arr = new int[1000000];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*1000 + 0);
		}
		
		int arr_size = arr.length;
		long start = System.currentTimeMillis();
		System.out.println(degreeOfArray(arr_size, arr));
		System.out.println(System.currentTimeMillis() - start);
	}

	public static int degreeOfArray(int arr_size, int[] arr) {
		
		Map<Integer, Integer> map = new TreeMap<>();
		
		for(int i=0; i<arr.length; i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				map.put(arr[i], 1);
			}
		}
		
		Map<Integer, Integer> sortedMap = sortMapByValues(map);
		return sortedMap.get(((TreeMap<Integer, Integer>) sortedMap).lastKey());
	}
	
	public static <K, V extends Comparable<V>> Map<K,V> sortMapByValues(final Map<K,V> map){
		Comparator<K> compareValue = new Comparator<K>() {

			@Override
			public int compare(K o1, K o2) {
				return map.get(o1).compareTo(map.get(o2));
			}
		};
		
		Map<K,V> sortedMap = new TreeMap<K,V>(compareValue);
		sortedMap.putAll(map);
		return sortedMap;
	}
}
