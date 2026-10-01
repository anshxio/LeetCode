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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return res;
        }


        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        boolean leftToRight = true;
        while(!qu.isEmpty()){

            int level = qu.size();
            List<Integer> ans = new LinkedList<>();
            for(int i =0; i< level; i++){


                TreeNode node = qu.poll();
                ans.add(node.val);

                if(node.left != null){
                    qu.offer(node.left);
                }

                if(node.right != null){
                    qu.offer(node.right);
                }
            }

            if(!leftToRight){
                Collections.reverse(ans);
            }

            res.add(ans);

            leftToRight = !leftToRight;
        }
        return res;
    }
}