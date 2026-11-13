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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if( head == null || left == right){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preNode = dummy;
        ListNode currNode = head;

        for(int i = 0; i < left-1; i++){
            preNode = preNode.next;
            currNode = currNode.next;
        }
        ListNode prev = null;
        ListNode subHead = currNode;

        for(int i =0; i<right-left+1; i++){
            ListNode nextNode = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = nextNode;
        }
        preNode.next = prev;
        subHead.next = currNode;
        return dummy.next;
    }
}