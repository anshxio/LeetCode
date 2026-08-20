class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l1.add(nums[0]);
        l2.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int last1 = l1.get(l1.size() - 1);
            int last2 = l2.get(l2.size() - 1);
            if (last1 > last2) {
                l1.add(nums[i]);
            } else {
                l2.add(nums[i]);
            }
        }
        List<Integer> res = new ArrayList<>();
        res.addAll(l1);
        res.addAll(l2);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}