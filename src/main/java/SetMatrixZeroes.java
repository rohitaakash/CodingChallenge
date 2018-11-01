import java.util.HashSet;

public class SetMatrixZeroes {

	public void setZeroes1(int[][] matrix) {

		HashSet<Integer> rows = new HashSet<>();
		HashSet<Integer> cols = new HashSet<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					if (!rows.contains(i))
						rows.add(i);
					if (!cols.contains(j))
						cols.add(j);
				}
			}
		}

		// for (int i = 0; i < matrix.length; i++) {
		// if (!rows.contains(i)) {
		// for (int j = 0; j < matrix[0].length; j++) {
		// if (!(rows.contains(i) && cols.contains(j))) {
		// if (matrix[i][j] == 0) {
		// rows.add(i);
		// cols.add(j);
		// }
		// }
		// }
		// }
		// }

		for (Integer row : rows) {
			makeZeroRow(row, matrix);
		}

		for (Integer col : cols) {
			makeZeroCol(col, matrix);
		}

	}

	public void makeZeroRow(int row, int[][] matrix) {
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[row][i] = 0;
		}
	}

	public void makeZeroCol(int col, int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}

	public void setZeroes2(int[][] matrix) {
		
		int col0 = 1;
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[i][0] == 0) col0 = 0;
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 1; j--) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
			if (col0 == 0) matrix[i][0] = 0;
		}
	}

	public void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
				if (j != matrix[0].length - 1) {
					System.out.print(",");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 0, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 }, { 1, 2, 1, 3 }, { 0, 0, 1, 1 } };
		
		SetMatrixZeroes smz1 = new SetMatrixZeroes();
		smz1.setZeroes1(matrix);
		smz1.printMatrix(matrix);
		
		SetMatrixZeroes smz2 = new SetMatrixZeroes();
		smz2.setZeroes2(matrix);
		smz2.printMatrix(matrix);

	}

}
