class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;

        for (int left = 0; left <= n - 3; left++) {
            if (nums[left] == 0) {
                for (int right = left; right < left + 3; right++) {
                    if (nums[right] == 0) {
                        nums[right] = 1;
                    } else {
                        nums[right] = 0;
                    }
                }
                operations++;
            }
        }
        if (nums[n - 2] == 0 || nums[n - 1] == 0) {
            return -1;
        }
        return operations;
    }
}