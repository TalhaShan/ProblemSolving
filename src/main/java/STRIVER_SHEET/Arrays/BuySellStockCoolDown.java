package STRIVER_SHEET.Arrays;

public class BuySellStockCoolDown {
    /*

    Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:

Input: prices = [1]
Output: 0
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        if (prices.length == 1) return profit;
        boolean coolDown = false;
        boolean lastSell = false;
        int buy = 0;
        for (int i = 0; i < prices.length - 1; i++) {

            if (!coolDown) {
                if (prices[i + 1] > prices[i]) {
                    profit += prices[i + 1] - prices[i];
                    i += 2;
                }

            }

        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(arr));
    }

}
