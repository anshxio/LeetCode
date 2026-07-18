class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int [] dp  = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = nums[0];
        for(int i=1; i < n; i++){
            int take = nums[i];
            if(i > 1){
                take += dp[i-2];
            }
            int nonTake = 0 + dp[i-1];
            dp[i] = Math.max(take,nonTake);
        }
        return dp[n-1];
    }
}