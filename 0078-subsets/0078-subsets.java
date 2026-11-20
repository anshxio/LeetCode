class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempSet = new ArrayList<>();
        backtrack(res,nums,tempSet, 0);
        return res;
    }

    public void backtrack(List<List<Integer>>res, int[] nums, List<Integer>tempSet, int start){
        
        res.add(new ArrayList<>(tempSet));
        for(int i = start; i < nums.length; i++){
            tempSet.add(nums[i]);
            backtrack(res, nums, tempSet, i+1);
            tempSet.remove(tempSet.size() - 1);
        }
    }
}