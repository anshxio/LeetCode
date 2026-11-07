class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] postive = new int[nums.length/2];
        int[] negative = new int[nums.length/2];
        int[] res = new int[nums.length];

        int p = 0;
        int n = 0;

        for(int i= 0; i< nums.length; i++){
            if(nums[i] < 0){
                negative[n++] = nums[i];
            }else{
                postive[p++] = nums[i];
            }
        }

        for(int i = 0; i< nums.length/2; i++){
            res[2*i] = postive[i];
            res[2*i+1] = negative[i];
        }
        return res;
    }
}