class Solution {
    public int smallestIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            int sum = sumOfDigit(nums[i]);
            if(sum == i){
                return i;
            }
        }
        return -1;
    }
    public int sumOfDigit(int num){
        int sum = 0;
        while(num > 0){
            int digit  = num % 10;
            sum += digit;
            num = num/10;
        }
        return sum;
    }
}