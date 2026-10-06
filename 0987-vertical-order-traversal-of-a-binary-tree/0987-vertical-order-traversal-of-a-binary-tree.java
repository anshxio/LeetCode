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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();

        helper(root,0,0,map);

        for(TreeMap<Integer,PriorityQueue<Integer>> levels:map.values()){
            List<Integer> colsAns = new ArrayList<>();
            for(PriorityQueue<Integer> pq: levels.values()){
                while(!pq.isEmpty()){
                    colsAns.add(pq.poll());
                }
            }
            res.add(colsAns);
        }
        return res;
    }
    public static void helper(TreeNode node,int vertical,int level,TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map){
        if(node == null){
            return;
        }
        if(!map.containsKey(vertical)){
            map.put(vertical,new TreeMap<>());
        }
        if(!map.get(vertical).containsKey(level)){
            map.get(vertical).put(level,new PriorityQueue<>());
        }
        map.get(vertical).get(level).offer(node.val);
        if(node.left != null){
            helper(node.left,vertical-1,level+1,map);
        }
        if(node.right != null){
            helper(node.right,vertical+1,level+1,map);
        }   
    }
}