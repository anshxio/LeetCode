class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int lb = lowerBond(nums,target);
        if(lb == nums.length || nums[lb] != target){
            return res;
        }
        res[0] = lowerBond(nums,target);
        res[1] = upperBond(nums, target) - 1;

        return res;
    }
    private int lowerBond(int[] nums, int target){
        int ans = nums.length;
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] >= target){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
    private int upperBond(int[] nums, int target){
        int ans = nums.length;
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] > target){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}