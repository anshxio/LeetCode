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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();

        dfs(root,"",res);

        return res;
    }
    public void dfs(TreeNode node, String str, List<String> res){
        if(node == null){
            return;
        }

        if(str.isEmpty()){
            str = String.valueOf(node.val);
        }else{
            str = str + "->" + node.val;
        }

        if(node.left == null && node.right == null){
            res.add(str);
            return;
        }

        dfs(node.left,str, res);
        dfs(node.right,str, res);
    }
}