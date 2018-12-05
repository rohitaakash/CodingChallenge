public class L48RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(matrix);
        rotate(matrix);
        printMatrix(matrix);
    }

    private static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
            }
        }

        for (int k = 0; k <= 2 * (n - 1); k++) {
            int i, j;
            if (k < n) {
                i = 0; j = k;
            } else {
                j = n-1;
                i = k-j;
            }
            while (i < j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                i++;
                j--;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
                if (j < matrix.length - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
