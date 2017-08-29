/*
Given a linked list, determine if it has a cycle in it.

Example
Given -21->10->4->5, tail connects to node index 1, return true
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        // write your code here
        if (head == null) {
            return false;
        }
        ListNode once = head;
        ListNode twice = head.next;
        while(once != twice) {
            if (twice == null || twice.next == null) {
                return false;
            } //set as break condition
            once = once.next;
            twice = twice.next.next;
        }
        return true;
    }
}
