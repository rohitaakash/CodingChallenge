import java.util.Arrays;
import java.util.List;

public class BudgetShopping {

    public static void main(String[] args) {
        List<Integer> bundleQuantities = Arrays.asList(24,20);
        List<Integer> bundleCosts = Arrays.asList(20,19);
        System.out.println(unboundedKnapsack(50, bundleQuantities, bundleCosts));
    }

    private static int unboundedKnapsack(int n, List<Integer> bundleQuantities, List<Integer> bundleCosts) {
        int size = bundleQuantities.size();

        int dp[] = new int[n + 1];

        // Fill dp[] using above recursive formula 
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < size; j++) {
                if (bundleCosts.get(j) <= i) {
                    dp[i] = Math.max(dp[i], dp[i - bundleCosts.get(j)] +
                            bundleQuantities.get(j));
                }
            }
        }
        return dp[n];
    }

    private static int[] findNumberOfCoins(int[] coins, int amount)
    {
        int c = coins.length;
        int[] numberOfCoins = new int[coins.length];
        while (amount > 0)
        {
            c--;
            if (amount >= coins[c])
            {
                int quotient = amount / coins[c];
                amount = amount - coins[c] * quotient;
                numberOfCoins[c] = quotient;
            }

        }
        return numberOfCoins;
    }
}
