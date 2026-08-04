class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < mini) mini = nums[i];
            if (nums[i] > maxi)maxi = nums[i];
        }

        for (int i = mini; i <= maxi; i++) {
            boolean found = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    found = true;
                    break;
                }
            }
            if (!found)ans.add(i);
        }
        return ans;
    }
}