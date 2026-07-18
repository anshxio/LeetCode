class Solution {
    public boolean canJump(int[] nums) {
        int maxSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > maxSize){
                return false;
            }
            maxSize = Math.max(maxSize, i + nums[i]);
        }
        return true;
    }
}