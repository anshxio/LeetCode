class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int res = 0;
        boolean found = false;
        for(int i = 0; i<n; i++){
            if(nums[i] != i){
                if(!found){
                    res = nums[i];
                    found = true;
                }else{
                    res = res & nums[i];
                }
            }
        }
        return res;
    }
}