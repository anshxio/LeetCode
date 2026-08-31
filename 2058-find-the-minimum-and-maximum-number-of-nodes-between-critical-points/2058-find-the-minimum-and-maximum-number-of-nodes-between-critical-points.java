/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode temp = head.next;
        int index = 1;
        int firstPoint = -1;
        int criticalPoint = -1;
        int lastPoint = -1;

        int minDistance = Integer.MAX_VALUE;

        while(temp.next != null){
            boolean isMax = prev.val < temp.val && temp.val > temp.next.val;
            boolean isMin = prev.val > temp.val && temp.val < temp.next.val;

            if(isMax || isMin){

                if(firstPoint == -1){
                    firstPoint = index;
                    criticalPoint = index;
                }else{
                    minDistance = Math.min(minDistance, index - criticalPoint);
                    criticalPoint = index;
                    lastPoint = index;
                }
            }
            prev = temp;
            temp = temp.next;
            index++;
        }
        if(lastPoint == -1){
            return new int[]{-1,-1};
        }

        int maxDistance = lastPoint - firstPoint;

        return new int[]{minDistance, maxDistance};
    }
}