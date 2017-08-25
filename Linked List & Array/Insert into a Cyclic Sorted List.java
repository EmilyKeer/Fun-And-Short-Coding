/*
Given a node from a cyclic linked list which has been sorted, write a function to insert a value into the list such that it remains a cyclic sorted list. The given node can be any single node in the list. Return the inserted new node.

 Notice

3->5->1 is a cyclic list, so 3 is next node of 1.
3->5->1 is same with 5->1->3

Example
Given a list, and insert a value 4:
3->5->1
Return 5->1->3->4
*/




//Not that good workable solution: squeeze all possibilities together
/*
 /
/
consider relation from smallest to largest
eage cases:
1. only one node
2. null
3. duplicate nodes:
    x == somenode.val
    all same nodes (insert whatever place; should use a start flag)


*/

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
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        ListNode newNode = new ListNode(x);
        if (node == null) {
            newNode.next = newNode;
            return newNode;
        }
        if (node.next == node) {
            node.next = newNode;
            newNode.next = node;
            return newNode;
        }
        ListNode start = node;
        ListNode pre = node;
        ListNode nex = node.next;
        while(pre.val > x) {
            pre = nex;
            nex = nex.next;
            if (nex.val < pre.val && x < nex.val || pre == start) {
                pre.next = newNode;
                newNode.next = nex;
                return newNode;
            }
        }
        while(pre.val <= x && nex.val <= x) {
            pre = nex;
            nex = nex.next;
            if (nex.val < pre.val && x > pre.val || pre.val == x || pre == start) {
                pre.next = newNode;
                newNode.next = nex;
                return newNode;
            }
        }
        pre.next = newNode;
        newNode.next = nex;
        return newNode;
    }
    
}

//clear solution with thoughts
/*
Idea:
1. from smallest to largest, insert: pre < x < nex
2. if x is smallest/largest: pre>nex && x<nex  /   pre>nex && x>pre
3. if duplicate:
    a. x same as some node in a unique list: pre <= x <= nex
    b. some nodes in list duplicate
    c. all same nodes : pre == node
4. eage cases:
    a. null
    b. one node
*/

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
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        if (node == null) {
            ListNode newNode = new ListNode(x);
            newNode.next = newNode;
            return newNode;
        }
        ListNode pre = null;
        ListNode nex = node;
        do {
            pre = nex;
            nex = nex.next;
            if (pre.val <= x && nex.val >= x) {
                break;
            }
            if (pre.val > nex.val && (pre.val < x || x < nex.val)) {
                break;
            }
        } while(nex != node);
        ListNode newNode = new ListNode(x);
        pre.next = newNode;
        newNode.next = nex;
        return newNode;
    }
}