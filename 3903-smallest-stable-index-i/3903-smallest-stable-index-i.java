class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int stable = Integer.MAX_VALUE;
        int instableScore = 0;
        for(int i =0; i<nums.length; i++){
            instableScore = maximum(i,nums) - minimum(i,nums);
            if(instableScore <= k){
                stable = Math.min(stable, i);
            }
        }
        if(stable == Integer.MAX_VALUE){
            return -1;
        }
        return stable;
    }
    public int minimum(int idx, int[]nums){
        int mini = nums[idx];
        for(int i = idx; i<nums.length; i++){
            if(nums[i] < mini){
                mini = nums[i];
            }
        }
        return mini;
    }
    public int maximum(int idx, int[]nums){
        int max = nums[0];
        for(int i =0; i <= idx; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
}