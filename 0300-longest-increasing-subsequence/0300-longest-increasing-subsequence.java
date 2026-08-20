class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [][] dp = new int[n+1][n+1];
        for(int i =0; i< n; i++){
            Arrays.fill(dp[i], -1);
        }
        return lis(0,-1,nums,dp);
    }
    public int lis(int index, int prev_indx, int[]nums, int[][]dp){
        if(index == nums.length){
            return 0;
        }
        if(dp[index][prev_indx+1] != -1){
            return dp[index][prev_indx+1];
        }
        dp[index][prev_indx+1] = 0 + lis(index+1, prev_indx, nums,dp);
        if(prev_indx == -1 || nums[index] > nums[prev_indx]){
            dp[index][prev_indx+1] =  Math.max(dp[index][prev_indx+1], 1 + lis(index+1, index,nums,dp));
        }
        return dp[index][prev_indx+1];
    }
}