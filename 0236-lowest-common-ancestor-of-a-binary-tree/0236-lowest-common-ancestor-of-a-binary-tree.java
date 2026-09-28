/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }

        TreeNode lft = lowestCommonAncestor(root.left, p, q);
        TreeNode rgt = lowestCommonAncestor(root.right, p, q);

        if(lft != null && rgt != null){
            return root;
        }

        if(lft == null){
            return rgt;
        }else{
            return lft;
        } 
    }
}