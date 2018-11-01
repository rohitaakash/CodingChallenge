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

		Queue<Elements> maxHeap = new PriorityQueue<>(k, new Comparator<Elements>() {

			@Override
			public int compare(Elements arg0, Elements arg1) {
				// TODO Auto-generated method stub
				return arg1.distance - arg0.distance;
			}

		});

		Elements temp = null;
		for (int i = 0; i < k; i++) {
			temp = new Elements(Math.abs(num - arr[i]), i);
			maxHeap.add(temp);
		}

		for (int i = k; i < arr.length; i++) {
			if (!maxHeap.isEmpty() && maxHeap.peek().distance > Math.abs(num - arr[i])) {
				maxHeap.poll();
				temp = new Elements(Math.abs(num - arr[i]), i);
				maxHeap.add(temp);
			}
		}

		int[] output = new int[k];
		for (int i = 0; i < k; i++) {
			output[i] = arr[maxHeap.poll().index];
		}

		return output;
	}

}

class Elements{
	int distance;
	int index;
	
	public Elements(int distance, int index) {
		this.distance = distance;
		this.index = index;
	}
}
