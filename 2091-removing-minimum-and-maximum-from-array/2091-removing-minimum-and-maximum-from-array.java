class Solution {
    public int minimumDeletions(int[] nums) {
        int maxi = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxi) {
                maxi = nums[i];
            }
        }
        int mini = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < mini) {
                mini = nums[i];
            }
        }
        int frontDelMax = 0;
        int frontDelMin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxi) {
                frontDelMax = i + 1;
            }
            if (nums[i] == mini) {
                frontDelMin = i + 1;
            }
        }
        int backDelMax = 0;
        int backDelMin = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == maxi) {
                backDelMax=  nums.length - i;
            }
            if (nums[i] == mini) {
                backDelMin =  nums.length - i;
            }
        }

        int pick1 = Math.max(frontDelMax,frontDelMin);
        int pick2 = Math.max(backDelMax,backDelMin);
        int pick3 = frontDelMax + backDelMin;
        int pick4 = frontDelMin + backDelMax;

        return Math.min(Math.min(pick1,pick2),Math.min(pick3,pick4));
    }
}