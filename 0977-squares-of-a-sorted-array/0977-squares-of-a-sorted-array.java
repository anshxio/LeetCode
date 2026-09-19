class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int[] res = new int[nums.length];

        int k = nums.length-1;

        while(left <= right){
            int leftSq = nums[left]* nums[left];
            int rightSq = nums[right]* nums[right];

            if(leftSq < rightSq){
                res[k] = rightSq;
                right--;
            }else{
                res[k] = leftSq;
                left++;
            }
            k--;
        }
        return res;
    }
}