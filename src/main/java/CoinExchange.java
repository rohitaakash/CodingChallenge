import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CoinExchange {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String values[] = line.split(" ");

		int balance = Integer.parseInt(values[0]);
		int withdraw = Integer.parseInt(values[1]);
		int packets = Integer.parseInt(values[2]);

		int coins[] = new int[packets];

		String next;
		for (int i = 0; i < packets; i++) {
			next = br.readLine();
			coins[i] = Integer.parseInt(next);
		}

		if (balance < withdraw || withdraw <= 0)
			System.out.print("Cannot put into packets");
		else
			coinExhangeTopDown(coins, withdraw, balance);

		br.close();
	}

	public static int minCoinsRecursion(int[] coins, int value) {
		if (value == 0)
			return 0;

		int count = 0, min = Integer.MAX_VALUE;
		for (int i = coins.length - 1; i >= 0; i--) {
			if (coins[i] <= value) {
				count = minCoinsRecursion(coins, value - coins[i]);
				if (count != Integer.MAX_VALUE)
					count++;
				if (count < min) {
					min = count;
				}
				if (count == 1)
					break;
			}
		}
		return min;
	}

	public static int minCoinsTopDown(int[] coins, int value) {
		int[] minCoin = new int[value + 1];

		for (int i = 0; i <= value; i++) {
			minCoin[i] = -1;
		}

		minCoin[0] = 0;
		return dpHelper(coins, value, minCoin);
	}

	public static int dpHelper(int[] coins, int value, int[] minCoin) {
		if (minCoin[value] != -1)
			return minCoin[value];

		int min = Integer.MAX_VALUE;
		for (int i = coins.length - 1; i >= 0; i--) {
			if (coins[i] <= value) {
				int count = dpHelper(coins, value - coins[i], minCoin);
				if (count != Integer.MAX_VALUE)
					count++;
				if (count < min)
					min = count;
				if (count == 1)
					break;
			}
		}

		minCoin[value] = min;
		return minCoin[value];
	}

	public static void coinExhangeTopDown(int coins[], int withdraw, int balance) {

		HashMap<Integer, Integer> cache = new HashMap<>();
		boolean[] check = new boolean[1];

		check[0] = false;
		coinExchangeTopDown(coins, withdraw, cache, "", check);

		if (check[0])
			System.out.print(balance - withdraw);
		else
			System.out.print("Cannot put into packets");

	}

	private static int coinExchangeTopDown(int coins[], int withdraw, HashMap<Integer, Integer> cache, String wallet,
			boolean flag[]) {

		if (withdraw == 0) {
			if (!flag[0]) {
				flag[0] = true;
				String answer = wallet.substring(1);
				String packets[] = answer.split(",");
				HashMap<String, Integer> count = new HashMap<>();

				for (int i = 0; i < packets.length; i++) {
					if (count.containsKey(packets[i]))
						count.put(packets[i], count.get(packets[i]) + 1);
					else
						count.put(packets[i], 1);
				}

				for (int i = 0; i < coins.length; i++) {
					if (!count.containsKey(coins[i] + ""))
						System.out.print(0 + ":" + coins[i] + " ");
					else
						System.out.print(count.get(coins[i] + "") + ":" + coins[i] + " ");
				}
				return 0;
			}
		}
		if (cache.containsKey(withdraw))
			return cache.get(withdraw);

		int min = Integer.MAX_VALUE;
		for (int i = coins.length - 1; i >= 0; i--) {
			if (withdraw >= coins[i]) {
				int count = coinExchangeTopDown(coins, withdraw - coins[i], cache, wallet + "," + coins[i], flag);
				if (count != Integer.MAX_VALUE && count < min - 1)
					min = count + 1;
			}
		}

		if (min != Integer.MAX_VALUE)
			cache.put(withdraw, min + 1);
		return (!cache.containsKey(withdraw)) ? min : cache.get(withdraw);
	}
}
