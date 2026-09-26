/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        sumPath(root, targetSum, path, ans);

        return ans;

    }

    public void sumPath(TreeNode node, int targetSum, List<Integer> sum, List<List<Integer>> ans) {

        if (node == null) {
            return;
        }
        sum.add(node.val);
        if (node.left == null && node.right == null) {
            if(targetSum == node.val){
                ans.add(new ArrayList<>(sum));
            }
        }else{
            targetSum -= node.val;

            sumPath(node.left,targetSum, sum, ans);
            sumPath(node.right,targetSum, sum, ans);
        }    
        sum.remove(sum.size() - 1);
    }
}