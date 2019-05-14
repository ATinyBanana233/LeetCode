/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution{
    /**
     * Remove nth node from the end of the linked list, end means after the last element.
     * @param head          Head of the linked list.
     * @param n             Nth element.
     * @return              The head of the linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        // Increment curr n times.
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }

        // The follower that would move with curr indicates the node to be removed.
        ListNode follower = head;
        // Keep track of the previous element.
        ListNode prev = head;
        while (curr != null) {
            curr = curr.next;
            prev = follower;
            follower = follower.next;
        }

        // If follower did not move, that means we need to remove the head.
        if (follower == head) {
            if (head.next != null) {
                return head.next;
            }
            else {
                return null;
            }
        }

        // Remove follower by skipping it.
        prev.next = follower.next;
        // Remove references.
        follower = null;

        return head;
    }
}