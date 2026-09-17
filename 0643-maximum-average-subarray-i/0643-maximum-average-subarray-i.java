class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum+= nums[i];
        }
        int maxSum = sum;
        int l =0;
        int r = k;
        while( r < nums.length){
            sum -= nums[l];
            l++;
            sum += nums[r];
            r++;

            maxSum = Math.max(maxSum, sum);
        }
        return (double)maxSum / k;
    }
}