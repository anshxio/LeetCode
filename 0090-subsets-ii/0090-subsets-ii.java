class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsetSum = new ArrayList<>();
        helper(0,nums,new ArrayList<>(), subsetSum);
        return subsetSum;
    }
    public void helper(int indx,int[]nums,List<Integer> ds, List<List<Integer>> subsetSum){
        subsetSum.add(new ArrayList<>(ds));
        for(int i=indx; i < nums.length; i++){
            if(i != indx && nums[i] == nums[i-1]) continue;
            ds.add(nums[i]);
            helper(i+1, nums, ds, subsetSum);
            ds.remove(ds.size()-1);
        }
    }
}