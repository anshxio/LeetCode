class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[]prev = new int[amount + 1];
        Arrays.fill(prev,0);
        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0) {
                prev[t] = t / coins[0];
            } else {
                prev[t] = (int) 1e9;
            }
        }
        for (int i = 1; i < n; i++) {
            int[] curr = new int[amount+1];
            for (int tar = 0; tar <= amount; tar++) {
                int notTake = 0 + prev[tar];
                int take = (int) 1e9;
                if (coins[i] <= tar) {
                    take = 1 + curr[tar-coins[i]];
                }
                curr[tar] = Math.min(take, notTake);
            }
            prev = curr;
        }
        int ans = prev[amount];
        return ans >= (int) 1e9? -1 : ans;
    }
}