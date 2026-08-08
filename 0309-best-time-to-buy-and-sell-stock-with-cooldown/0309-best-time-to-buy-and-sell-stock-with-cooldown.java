class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int[n][2];
        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        return profit(0,1,prices,dp);
    }
    public int profit(int index, int buy, int[]prices, int[][] dp){
        if(index >= prices.length){
            return 0;
        }
        if(dp[index][buy] != -1){
            return dp[index][buy];
        }
        if(buy == 1){
            return dp[index][buy] = Math.max(-prices[index] + profit(index+1,0,prices,dp), 0 + profit(index+1,1,prices,dp));
        }else{
            return dp[index][buy] = Math.max(prices[index] + profit(index+2,1,prices,dp), 0 + profit(index+1,0,prices,dp));
        }
    }
}