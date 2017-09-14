/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
/* Not a good question, you cannot buy and sell at the same time, but you can do it in the same day.
* Greedy algorithm, finding every up spike in the price array, sum them up */
public class Best_Time_to_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        if(prices.length<2)
            return 0;
        int total=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i-1]<prices[i])
                total += (prices[i]-prices[i-1]);
        }
        return total;
    }
    public static void main(String[] args){
        int[] prices = {2,3,7,4,3,2,7,5,4,3};
        System.out.print(new Best_Time_to_Buy_and_Sell_Stock_II().maxProfit(prices));
    }
}
