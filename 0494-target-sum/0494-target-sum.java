class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return seq(nums,0,0,target);
    }
    private int seq(int[]nums,int index,int sum,int target){
        if(index ==nums.length){
            return sum == target ?1:0;
        }
        int add = seq(nums,index+1,sum+nums[index],target);
        int subtract = seq(nums,index+1,sum-nums[index],target);
        return add+subtract;
    }
}