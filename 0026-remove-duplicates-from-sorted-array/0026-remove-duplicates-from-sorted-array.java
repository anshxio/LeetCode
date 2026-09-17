class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int index = 1;
        if(nums.length == 0 ) return 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                nums[index] = nums[j];
                i++;
                index++;
            }
        }
        return index;
    }
}