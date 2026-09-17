class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        int maxOnes = 0;
        int i = 0;
        for(int j =0; j < nums.length; j++){

            if(nums[j] == 0){
                count++;
            }

            while(count > k){
                if(nums[i] == 0){
                    count--;
                }

                i++;
            }

            maxOnes = Math.max(maxOnes, j-i+1);
            
        }
        return maxOnes;
    }
}