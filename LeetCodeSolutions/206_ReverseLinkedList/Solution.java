/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode currToProcess = head, nextToProcess = null, prev = null;
        while (currToProcess != null) {
            nextToProcess = currToProcess.next;
            currToProcess.next = prev;
            prev = currToProcess;
            currToProcess = nextToProcess;
        }

        head = prev;
        return head;
    }
}