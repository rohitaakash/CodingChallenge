import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumColoring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = { { 5, 4, 4 }, { 4, 3, 4 }, { 3, 2, 4 }, { 2, 2, 2 }, { 3, 3, 4 }, { 1, 4, 4 }, { 4, 1, 1 } };
		System.out.println(solution(A));
	}

	public static int solution(int[][] A) {
		Queue<List<Integer>> queue = new LinkedList<>();
		List<Integer> list, temp;
		int count = 0, rows = A.length, cols = A[0].length, row, col;

		int painted[][] = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (painted[i][j] == 1)
					continue;

				list = new ArrayList<>();
				list.add(i);
				list.add(j);
				queue.add(list);
				count++;

				while (!queue.isEmpty()) {
					temp = queue.poll();
					row = temp.get(0);
					col = temp.get(1);

					painted[row][col] = 1;

					if ((row - 1 >= 0) && painted[row - 1][col] != 1 && (A[row - 1][col] == A[row][col])) {
						list = new ArrayList<>();
						list.add(row - 1);
						list.add(col);
						queue.add(list);

					}

					if ((col - 1) >= 0 && painted[row][col - 1] != 1 && (A[row][col - 1] == A[row][col])) {
						list = new ArrayList<>();
						list.add(row);
						list.add(col - 1);
						queue.add(list);
					}

					if (col + 1 < A[0].length && painted[row][col + 1] != 1 && (A[row][col + 1] == A[row][col])) {
						list = new ArrayList<>();
						list.add(row);
						list.add(col + 1);
						queue.add(list);
					}

					if ((row + 1) < A.length && painted[row + 1][col] != 1 && (A[row + 1][col] == A[row][col])) {
						list = new ArrayList<>();
						list.add(row + 1);
						list.add(col);
						queue.add(list);
					}
				}
			}
		}

		return count;

	}

}
