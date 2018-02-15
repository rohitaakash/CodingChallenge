
public class SquareNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] arr = {"3 9", "17 24"};
		int[] result = getMinimumSquareNumbers(arr);
		
		for(int i: result) System.out.println(i);

	}
	
	public static int[] getMinimumSquareNumbers(String[] arr) {
		
		int[] result = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
			String[] pair = arr[i].split("\\s");
			int start = (int) Math.ceil(Math.sqrt(Integer.parseInt(pair[0])));
			int end = (int) Math.floor(Math.sqrt(Integer.parseInt(pair[1])));
			result[i] = end - start +1;
		}
		return result;
	}

}
