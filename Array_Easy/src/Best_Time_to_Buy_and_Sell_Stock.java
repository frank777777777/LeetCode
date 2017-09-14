/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Example 1:
 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 Example 2:
 Input: [7, 6, 4, 3, 1]
 Output: 0

 In this case, no transaction is done, i.e. max profit = 0.
 */
public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int max = 0, lowest = Integer.MAX_VALUE;
        /* Linear time complexity, keep track on the lowest value. Only update the max when it is greater than the previous max */
        for(int i=0;i<prices.length;i++){
            if(prices[i]<lowest)
                lowest=prices[i];
            if((prices[i]-lowest)>max)
                max = prices[i]-lowest;
        }
        return max;
    }
    public static void main(String[] args){
        int[] test = {1,3,2,7};
        System.out.print(new Best_Time_to_Buy_and_Sell_Stock().maxProfit(test));
    }
}
