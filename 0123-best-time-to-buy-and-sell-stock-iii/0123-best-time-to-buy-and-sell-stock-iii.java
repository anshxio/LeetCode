class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] after = new int[2][3];
        int[][] curr  = new int[2][3];
        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < 3; cap++) {
                    if (buy == 1) {
                        curr[buy][cap] = Math.max(-prices[index] + after[0][cap],
                                0 + after[1][cap]);
                    } else {
                        curr[buy][cap] = Math.max(prices[index] + after[1][cap - 1],
                                0 + after[0][cap]);
                    }
                }
            }
            after = curr;
        }
        return curr[1][2];
    }
}