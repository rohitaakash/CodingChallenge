import java.util.Arrays;

public class LargestPerimeterTriangle {

    public static void main(String[] args) {
        int[] A = {10, 2, 5, 1, 8, 20};
        System.out.println(largestPerimeterTriangle(A));
    }

    private static int largestPerimeterTriangle(int[] arr) {
        Arrays.sort(arr);
        int i=arr.length-1;

        while (i>=2) {
            if(checkTriangleProperty(arr[i], arr[i-1], arr[i-2]))
                return arr[i] + arr[i-1] + arr[i-2];
            else
                i--;
        }

        return -1;
    }

    private static boolean checkTriangleProperty(int a, int b, int c) {
        return (a + b > c) && (b + c > a) && (a + c > b);
    }
}
