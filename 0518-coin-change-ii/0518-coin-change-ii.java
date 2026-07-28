class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount + 1];
        Arrays.fill(prev, 0);
        for (int t = 0; t <= amount; t++) {
            if (t % coins[0] == 0)
                prev[t] = 1;
        }
        for (int i = 1; i < n; i++) {
            int[] curr = new int[amount + 1];
            for (int tar = 0; tar <= amount; tar++) {
                int notTake = 0 + prev[tar];
                int take = 0;
                if (coins[i] <= tar) {
                    take += curr[tar - coins[i]];
                }
                curr[tar] = take + notTake;
            }
            prev = curr;
        }
        return  prev[amount];
        
    }
}