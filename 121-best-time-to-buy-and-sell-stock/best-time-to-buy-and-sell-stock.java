class Solution {
    public int maxProfit(int[] prices) {
           // PATTERN: Running Minimum + Maximum
        // Keep the cheapest price seen so far.
        // Calculate today's profit and update maximum.

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int price : prices) {

            minPrice = Math.min(minPrice, price);

            int profit = price - minPrice;

            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
        
        //    int n = prices.length;
        // int min = prices[0];
        // int index = 0;
        // for(int i =1; i<n; i++){
        //    if(prices[i]<min){
        //     min = prices[i];
        //     index ++;
        //    }
        // }
        // int max = min;
        // int i = index;
        //   for(i = index; i<n; i++){
        //   if(prices[i]>max ){
        //     max = prices[i];
        //   }
        //   }
        // return max - min;  
    }
}