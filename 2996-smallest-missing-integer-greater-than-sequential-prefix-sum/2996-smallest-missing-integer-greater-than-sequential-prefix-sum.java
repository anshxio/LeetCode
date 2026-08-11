class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        boolean[] hashTable = new boolean[1276];
        for (int num : nums) {
            hashTable[num] = true;
        }
        int sequentialSum = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sequentialSum += nums[i];
            } else {
                break;
            }
        }

        while (hashTable[sequentialSum]) {
            sequentialSum++;
        }

        return sequentialSum;
    }
}