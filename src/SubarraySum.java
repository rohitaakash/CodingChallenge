public class SubarraySum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(subarraySum(arr));
    }

    private static int subarraySum(int[] arr) {
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            if(i==0 || i== arr.length-1) {
                sum += arr[i]*arr.length;
            }else{
                sum += arr[i]*(2*arr.length-2);
            }

        }
        return sum;
    }
}
