class Solution {

    ListNode getKthNode(ListNode temp, int k) {
        k--;
        while(temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }
    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;
        ListNode prevLast = null;

        while(temp != null) {
            // Find kth node
            ListNode kthNode = getKthNode(temp, k);
            // If fewer than k nodes remain
            if(kthNode == null) {
                if(prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }
            // Save next group's starting node
            ListNode nextNode = kthNode.next;
            // Disconnect current group
            kthNode.next = null;
            // Reverse current group
            reverse(temp);
            // First group: update head
            if(temp == head) {
                head = kthNode;
            } else {
                prevLast.next = kthNode;
            }
            // Old group head becomes the last node
            prevLast = temp;
            // Move to next group
            temp = nextNode;
        }
        return head;
    }
}