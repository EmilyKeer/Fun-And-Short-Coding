/*
Reverse a linked list from position m to n.

Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
*/

//Keer's solution

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        ListNode nodePreM = null;
        ListNode nodeAtN = null;
        ListNode nodeAfterN = null;
        ListNode nodeCur = new ListNode(0);
        nodeCur.next = head;
        int count = 0;
        while (nodeCur != null) {
            if (count == m-1) {
                nodePreM = nodeCur;
            }
            else if (count == n){
                nodeAtN = nodeCur;
                nodeAfterN = nodeCur.next;
                break;
            }
            nodeCur = nodeCur.next;
            count++;
        }

        ListNode newHead, cur, temp;
        newHead = nodePreM.next;
        cur = newHead.next;
        while (cur!=null) {
            temp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = temp;
        }
        nodePreM.next.next = nodeAfterN;
        nodePreM.next = newHead;

        return head;
    }
}

//One Correct solution
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 * }
 */
public class Solution {
    /*
    1.find premNode
    2.track mNode, let nNode=mNode, put postnNode
    3.for loop move nNode postnNode
    */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //empty list and boundary cases
        if (m >= n || head == null) {
            return head;
        }
        //if m == 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) {
            head = head.next;
        }

        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode, postnNode = mNode.next;
        for (int i = m; i < n; i++) {
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;

        return dummy.next;
    }
}
