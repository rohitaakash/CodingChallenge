public class EqualSumSplit {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1, 2, 1, 1, 1, 1};
        int[] B = {10, 1, 8, 1, 1, 1, 5, 4};
        System.out.println(equalSumSplit(A));
        System.out.println(equalSumSplit(B));
    }

    private static boolean equalSumSplit(int[] arr) {
        int arrSum = 0, i = 0, j = arr.length - 1, lSum = arr[i], rSum = arr[j];

        for (int anArr : arr) {
            arrSum += anArr;
        }

        while (j - i >= 2) {
            if (lSum == rSum) {
                if (arrSum - arr[i+1] - arr[j-1] == 3*lSum) {
                    return true;
                }
                else {
                    i++;
                    j--;
                    lSum += arr[i];
                    rSum += arr[j];
                }
            } else if (lSum < rSum) {
                i++;
                lSum += arr[i];
            } else {
                j--;
                rSum += arr[j];
            }
        }
        return false;
    }
}
