class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int target = nums[nums.length/2];

        long moves = 0;

        for(int i = 0; i<nums.length; i++){
            moves+= Math.abs((long) nums[i] - target);
        }
        return (int) moves;
    }
}