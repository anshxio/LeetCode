class Solution {
    public int minMoves(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int it: nums){
            max = Math.max(max, it);
        }
        int res = 0;
        for(int it: nums){
            res+=  (max - it);
        }
        return res;
    }
}