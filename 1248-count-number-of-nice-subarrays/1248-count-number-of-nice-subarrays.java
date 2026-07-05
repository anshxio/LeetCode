class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = subArrays(nums,k) - subArrays(nums, k-1);
        return ans;
    }
    public int subArrays(int[] nums, int goal){
        int l=0,r=0;
        int sum =0, count=0;
        int n = nums.length;
        if(goal < 0){
            return 0;
        }
        while(r<n){
            sum += nums[r] %2;
            while(sum > goal){
                sum -= nums[l]%2;
                l++; 
            }
            count = count + (r-l+1);
            r++; 
        }
        return count;
    }
}