
public class MinimumMoves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {123,543};
		int[] m = {321,279};
		System.out.println(minimumMoves(a,m));

	}

	public static int minimumMoves(int[] a, int[] m) {
		int moves = 0;
		
		for (int i = 0; i < m.length; i++) {
			String j = Integer.toString(a[i]), k = Integer.toString(m[i]);
			for(int l=0; l<j.length(); l++) {
				int diff = Math.abs(j.charAt(l) - k.charAt(l));
				moves += diff;
			}
			
		}
		return moves;
		
	}
}
