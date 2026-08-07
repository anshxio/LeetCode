class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < 3; cap++) {
                    if (buy == 1) {
                        dp[index][buy][cap] = Math.max(-prices[index] + dp[index + 1][0][cap],
                                0 + dp[index + 1][1][cap]);
                    } else {
                        dp[index][buy][cap] = Math.max(prices[index] + dp[index + 1][1][cap - 1],
                                0 + dp[index + 1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}