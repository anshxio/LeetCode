class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans =  minCoin(n-1, coins, amount, dp);
        return ans >= (int)1e9 ? -1 : ans;
    }
    public int minCoin(int indx, int[] coins, int amount, int[][] dp){
        if(indx == 0){
            if(amount % coins[indx] == 0){
                return amount/coins[0];
            }
            return (int)1e9;
        }
        if(dp[indx][amount] != -1){
            return dp[indx][amount];
        }

        int notTake = 0 + minCoin(indx-1, coins, amount, dp);
        int take = (int)1e9;
        if(coins[indx] <= amount){
            take = 1 + minCoin(indx, coins, amount - coins[indx], dp);
        }
        return dp[indx][amount] = Math.min(take,notTake);
    }
}