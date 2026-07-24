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
        boolean[] prev = new boolean[target+1];
        prev[0] = true;
        if(nums[0] <= target){
            prev[nums[0]] = true;
        }
        for(int i=1; i<n; i++){
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;
            for(int t = 1; t <= target; t++){
                boolean notTake = prev[t];
                boolean take = false;
                if(nums[i] <= t){
                    take = prev[t - nums[i]];
                }
                curr[t] = notTake || take;
            }
            prev = curr;
        }
        return prev[target];

    }
}