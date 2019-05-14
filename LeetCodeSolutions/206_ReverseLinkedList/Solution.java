/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * Function to reverse a linked list.
     * @param head          Head pointer.
     * @return              Head pointer
     */
    public ListNode reverseList(ListNode head) {
        ListNode currToProcess = head, nextToProcess = null, prev = null;

        while (currToProcess != null) {
            // Save the next node that needs to process.
            nextToProcess = currToProcess.next;
            // Change current.next.
            currToProcess.next = prev;
            // Prev would be current since we are doing reversed order.
            prev = currToProcess;
            // Next to process will be the next current to process.
            currToProcess = nextToProcess;
        }

        // Change the head.
        head = prev;
        return head;
    }
}