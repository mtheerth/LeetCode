package practise.leetcode;

class BuyandSellStock {
	//input prices = [7,1,5,3,6,4] , output 5
	//If prices[i] < minimum, the profit = prices[i] - min.
	// update the minimum as we traverse
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minvalue = Integer.MAX_VALUE;

    for (int i=0 ; i< prices.length; i++){
        if(prices[i] < minvalue){
            minvalue = prices[i];
        } else {
            maxProfit = Math.max(maxProfit , prices[i] - minvalue);
        }
    }
    return maxProfit;
    }
   public static void main(String args[]){
         int[]  prices = {7,1,5,3,6,4};
         System.out.println(maxProfit(prices));
   }
}
