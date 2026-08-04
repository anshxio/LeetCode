class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (mini > nums[i]) {
                mini = nums[i];
            }
            if (maxi < nums[i]) {
                maxi = nums[i];
            }
            set.add(nums[i]);
        }

        for (int i = mini; i < maxi; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}