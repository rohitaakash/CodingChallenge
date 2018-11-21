import java.util.Arrays;
import java.util.TreeMap;

public class SimpleQueries {

    public static void main(String[] args) {
        int[] nums = {2, 10, 5, 4, 8};
        int[] maxes = {3, 1, 7, 8};
        printArray(countsOptimized(nums, maxes));
    }

    private static int[] counts(int[] nums, int[] maxes) {
        int[] output = new int[maxes.length];
        for (int i = 0; i < maxes.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (maxes[i] >= nums[j])
                    count++;
            }
            output[i] = count;
        }
        return output;
    }

    private static int[] countsOptimized(int[] nums, int[] maxes) {
        int[] output = new int[maxes.length];
        TreeMap<Integer, Integer> numsMap = new TreeMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0)
                numsMap.put(nums[i], 1);
            else if (numsMap.containsKey(nums[i]))
                numsMap.put(nums[i], numsMap.get(nums[i]) + 1);
            else
                numsMap.put(nums[i], numsMap.get(nums[i - 1]) + 1);
        }

        System.out.println(numsMap);

        for (int j = 0; j < maxes.length; j++) {
            if (numsMap.containsKey(maxes[j]))
                output[j] = numsMap.get(maxes[j]);
            else {
                numsMap.put(maxes[j], 1);
                if (numsMap.lowerKey(maxes[j]) != null)
                    output[j] = numsMap.get(numsMap.lowerKey(maxes[j]));
                else
                    output[j] = 0;
                numsMap.remove(maxes[j]);
            }

        }
        return output;
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
