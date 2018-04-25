import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 6, 10, 1, 8, 9 };
		int[] output = getKClosestElements(arr, 7, 2);

		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

	public static int[] getKClosestElements(int[] arr, int num, int k) {

		Queue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				// TODO Auto-generated method stub
				return arg1 - arg0;
			}

		});

		for (int i = 0; i < k; i++) {
			maxHeap.add(Math.abs(num - arr[i]));
		}

		for (int i = k; i < arr.length; i++) {
			if (!maxHeap.isEmpty() && maxHeap.peek() > Math.abs(num - arr[i]))
				maxHeap.add(Math.abs(num - arr[i]));
		}

		int[] output = new int[k];
		for (int i = 0; i < k; i++) {
			output[i] = maxHeap.poll() + num;
		}

		return output;
	}

}
