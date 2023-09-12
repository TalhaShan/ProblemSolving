package SdeSheet;

public class BuyStocks {

//    Input: prices = [7,t1,5,3,6,4]
//    Output: 5
//    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//https://takeuforward.org/data-structure/stock-buy-and-sell/
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    max = Math.max(prices[j] - prices[i], max);
                }
            }
        }
        return max;
    }

    public static int maxProfitOpt(int[] prices) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            if (min < price) {
                max = Math.max(max, price - min);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfitOpt(prices));
    }

}
