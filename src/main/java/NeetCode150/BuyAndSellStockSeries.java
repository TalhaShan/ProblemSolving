package NeetCode150;

public class BuyAndSellStockSeries {

    public int maxProfit(int[] prices) {
        int buyStock = prices[0];
        int maxProfit=0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]<buyStock){
                buyStock=prices[i]; //Buy Day we can have ans as 0 as well so no need to worry of buying any day
                 //no need to do sell case since it will be -ve value so that'swhy in else
            }else{
                maxProfit=Math.max(maxProfit,prices[i]-buyStock); //found a day where our buying price is less so
            }
        }
        return maxProfit;
    }
}
