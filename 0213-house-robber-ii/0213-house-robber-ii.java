class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        if( n == 1){
            return nums[0];
        }
        for(int i=0; i < n; i++){
            if(i != 0){
                temp1[i] = nums[i];
            }
            if(i != n-1){
                temp2[i] = nums[i];
            }
        }
        return Math.max(helper(temp1), helper(temp2));

    }
    public int helper(int[] nums){
        int n = nums.length;
        int prev =nums[0];
        int prev2 = 0;
        for(int i= 1; i< n; i++){
            int take = nums[i];
            if(i>1){
                take += prev2;
            }
            int nonTake = 0 + prev;

            int curr = Math.max(take,nonTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}