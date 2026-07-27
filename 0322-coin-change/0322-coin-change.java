class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) {
                dp[0][t] = t / coins[0];
            } else {
                dp[0][t] = (int) 1e9;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int tar = 0; tar <= amount; tar++) {
                int notTake = 0 + dp[i-1][tar];
                int take = (int) 1e9;
                if (coins[i] <= tar) {
                    take = 1 + dp[i][tar-coins[i]];
                }
                dp[i][tar] = Math.min(take, notTake);
            }
        }
        int ans = dp[n-1][amount];
        return ans >= (int) 1e9? -1 : ans;
    }
}