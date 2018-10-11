import java.util.*;

public class MinimumArraySum {

    public static void main(String[] args) {

    }

    private static int getMinimumUniqueSum(int[] a) {
        int[] myIntArray = new int[]{2, 2, 4, 5};
        List<Integer> myList = new ArrayList<Integer>();
        for (int i = 0; i < myIntArray.length; i++) {
            myList.add(myIntArray[i]);
        }
        Collections.sort(myList);
        for (int i = 0; i < myList.size() - 1; i++) {
            if (myList.get(i) == myList.get(i + 1)) {
                myList.set(i + 1, myList.get(i + 1) + 1);
            }
        }
        int totalsum = 0;
        for (int i = 0; i < myList.size(); i++) {
            totalsum = totalsum + myList.get(i);
        }
        return totalsum;
    }

    private static int getMinimumUniqueSum2(int[] arr) {
        if (arr.length == 0) return 0;
        int sum = 0;
        Set<Integer> values = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            sum += num;
            if (values.contains(num)) {
                while (values.contains(num)) {
                    sum++;
                    num++;
                }
                values.add(num);
            } else {
                values.add(num);
            }
        }
        return sum;
    }
}
