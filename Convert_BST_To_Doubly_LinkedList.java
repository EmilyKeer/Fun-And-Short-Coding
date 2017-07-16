/*
Convert a binary search tree to doubly linked list with in-order traversal.

Given a binary search tree:

    4
   / \
  2   5
 / \
1   3
return 1<->2<->3<->4<->5

Solution hint:
1.assume left, right done, only root node is left; left result <-> root node <-> right result
2.Double list, should track first and last, use self defined class
3.recursion pattern:
null
call left
call right (same function return type, so need helper)
do "last step"
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
 class ReturnType {
     DoublyListNode first, last;
     ReturnType(DoublyListNode frist, DoublyListNode last) {
         this.first = first;
         this.last = last;
     }
 } 
 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        if (root == null) {
            return null;
        }
        ReturnType result = helper(root);
        return result.first;
    }
    
    private ReturnType helper(TreeNode root) {
        if(root == null) {
            return null;
        }
        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);
        DoublyListNode node = new DoublyListNode(root.val);
        ReturnType result = new ReturnType(null, null);
        if (left == null) {
            result.first = node;
        } else{
            result.first = left.first;
            left.last.next = node;
            node.prev = left.last;
        }
        if(right == null) {
            result.last = node;
        } else {
            result.last = right.last;
            right.first.prev = node;
            node.next = right.first;
        }
        return result;
    }
}
