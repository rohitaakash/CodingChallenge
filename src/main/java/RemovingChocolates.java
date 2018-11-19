public class RemovingChocolates {

    public static void main(String[] args) {
        System.out.println(numberOfWaysDp(6));
        System.out.println(numberOfWaysDpOptimized(24));
    }

    public static int numberOfWaysDp(int n) {
        int[] cache = new int[n+1];
        cache[0] = 1;
        cache[1] = 1;
        return numberOfWaysHelperTopDown(n, cache);
    }

    public static int numberOfWaysHelperTopDown(int n, int[] cache) {
        if (n < 0) return 0;
        if(cache[n] != 0) return cache[n];

        cache[n] = numberOfWaysHelperTopDown(n-1, cache) + numberOfWaysHelperTopDown(n-3, cache);

        return cache[n];
    }

    public static int numberOfWaysDpOptimized(int n) {
        int[] cache = new int[n+3];
        cache[0] = 1;
        cache[1] = 1;
        cache[2] = 2;
        cache[3] = 2;
        if(n < 4) return cache[n];
        return numberOfWaysHelperFibonacci(n, cache);
    }

    public static int numberOfWaysHelperFibonacci(int n, int[] cache) {
        if(n < 0) return 0;
        if(n==0) return 1;
//        if(cache[n%3] != 0) return cache[n%3];

        cache[n%3] = numberOfWaysHelperFibonacci(n-1, cache) + numberOfWaysHelperFibonacci(n-3, cache);
        return cache[n%3];
    }
}
