class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates,0,target,ans, new ArrayList<>());
        return ans;
    }
    private void helper(int[] candidates, int indx, int target, List<List<Integer>> ans,
    List<Integer> ds ){
        if(indx == candidates.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(candidates[indx] <= target){
            ds.add(candidates[indx]);
            helper(candidates,indx,target - candidates[indx],ans, ds);
            ds.remove(ds.size()-1);
        }
        helper(candidates,indx+1, target,ans,ds);
    }
}