
public class StockBuySell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int[] prices = { 1, 2, 3, 0, 2 };
		int[] prices = { 3, 3, 3 };
		System.out.println(maxProfit(prices));

	}

	public static int maxProfit(int[] prices) {
		int status = 3;
		int prevStatus = 2;

		return maxProfitDP(prices, status, prevStatus, 0, -1);
	}

	public static int maxProfitDP(int[] prices, int status, int prevStatus, int cp, int i) {
		if (i == prices.length)
			return 0;

		if (status == 2) {
			int currProfit = prices[i] - cp;
			return currProfit + maxProfitDP(prices, 3, 2, 0, i + 1);
		} else if (status == 1) {
			return Math.max(maxProfitDP(prices, 2, 1, prices[i], i + 1), maxProfitDP(prices, 3, 1, prices[i], i + 1));
		} else {
			if (prevStatus == 1) {
				return Math.max(maxProfitDP(prices, 2, 3, cp, i + 1), maxProfitDP(prices, 3, 1, cp, i + 1));
			} else if (prevStatus == 2) {
				return Math.max(maxProfitDP(prices, 1, 3, cp, i + 1), maxProfitDP(prices, 3, 2, cp, i + 1));
			}
		}

		return 0;

	}
}
