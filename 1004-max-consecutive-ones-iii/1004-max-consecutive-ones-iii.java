class Solution {
    public int longestOnes(int[] nums, int k) {
        int lnth = 0, count=0,l=0,r=0;
        int n = nums.length;
        while(r<n){
            if(nums[r] == 0) count++;
            if(count > k){
              if(nums[l] == 0) count--;
              l++;  
            }
            if(count <= k){
                lnth = Math.max(lnth, r-l+1);
            }
            r++;
        }
        return lnth;
    }
}