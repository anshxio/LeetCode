class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        int n = nums.length;
        for(int i=0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        int target = sum/2;
        int[][] dp = new int[n][target+1];
        for(int i =0; i< n; i++){
            Arrays.fill(dp[i] , -1);
        }
        return targetSum(n-1, nums,target, dp);
    }
    public boolean targetSum(int indx, int[] nums, int target,int [][] dp){
        if(target == 0){
            return true;
        }
        if(indx == 0){
            return nums[indx] == target;
        }
        if(dp[indx][target] != -1){
            return dp[indx][target] == 1;
        }
        boolean notTake = targetSum(indx-1, nums, target,dp);
        boolean take = false;
        if(nums[indx] <= target){
            take = targetSum(indx-1,nums, target - nums[indx],dp);
        }
        dp[indx][target] = take || notTake ? 1:0;
        return take || notTake;
    }
}