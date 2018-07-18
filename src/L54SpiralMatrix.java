import java.util.ArrayList;
import java.util.List;

public class L54SpiralMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4}, { 4, 5, 6, 7 }, { 7, 8, 9, 10 } };
		List<Integer> spiral = spiralOrder(matrix);
		System.out.println(spiral);
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> spiral = new ArrayList<>();
        if(matrix.length == 0) return spiral;
        
        int nrows = matrix.length, ncols = matrix[0].length;
        boolean[][] visited = new boolean[nrows][ncols];
		int total = nrows * ncols;

		int right = 1, down = 2, left = 3, up = 4;
		int row = 0, col = 0, i = 0;
		int dir = right;
		while (i < total ) {
			if (dir == right) {
				while (col < ncols) {
					if(!visited[row][col]) {
						spiral.add(matrix[row][col]);
						visited[row][col] = true;
						i++;
					}else break;
					col++;
				}
				col--;
				row++;
				dir = down;
			} else if(dir == down) {
				while (row < nrows) {
					if(!visited[row][col]) {
						spiral.add(matrix[row][col]);
						visited[row][col] = true;
						i++;
					}else break;
					row++;
				}
				row--;
				col--;
				dir = left;
			} else if(dir == left) {
				while (col >= 0) {
					if(!visited[row][col]) {
						spiral.add(matrix[row][col]);
						visited[row][col] = true;
						i++;
					}else break;
					col--;
				}
				row--;
				col++;
				dir = up;
			} else if(dir == up){
				while (row >= 0) {
					if(!visited[row][col]) {
						spiral.add(matrix[row][col]);
						visited[row][col] = true;
						i++;
					}else break;
					row--;
				}
				row++;
				col++;
				dir = right;
			}
		}

		return spiral;
	}
}
