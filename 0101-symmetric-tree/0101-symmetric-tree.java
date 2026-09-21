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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode lft, TreeNode rgt){
        if(lft == null || rgt == null){
            return lft == rgt;
        }
        if(lft.val != rgt.val){
            return false;
        }
        return isMirror(lft.left, rgt.right) && isMirror(lft.right, rgt.left);
    }
}