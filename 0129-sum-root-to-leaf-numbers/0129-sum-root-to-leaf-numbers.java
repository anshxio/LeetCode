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
    public int sumNumbers(TreeNode root) {
        return sumRoot(root,0, 0);
    }
    public int sumRoot(TreeNode node, int res, int sum){

        if(node == null){
            return 0;
        }

        sum = sum*10 + node.val;

        if(node.left == null && node.right == null){
            res += sum;
            return res;
        }

       return sumRoot(node.left,res, sum) + sumRoot(node.right,res, sum);
    }
}