class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i =0;
        int j =0;
        int ans = 0;
        int minLen = Integer.MAX_VALUE;
        while(j < nums.length){
            ans += nums[j];
            
            while(ans >= target){
                ans -= nums[i];
                minLen = Math.min(minLen, j-i+1);
                i++;
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ? 0:minLen;
    }
}