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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder, map, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] postorder, Map<Integer, Integer> map, int rootIndex, int left, int right) {
        TreeNode root = new TreeNode(postorder[rootIndex]);
        int mid = map.get(postorder[rootIndex]);
        if (mid < right) {
            root.right = buildTree(postorder, map, rootIndex - 1, mid + 1, right);
        }
        if (mid > left) {
            root.left = buildTree(postorder, map, rootIndex - (right - mid) - 1, left, mid - 1);
        }
        return root;
    }
}