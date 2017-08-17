/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
A single node tree is a BST
Example
An example:

  2
 / \
1   4
   / \
  3   5
The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).
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
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // Long is for long number
        return checkEachBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean checkEachBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        
        boolean left = checkEachBST(root.left, min, Math.min(max, root.val));
        boolean right = checkEachBST(root.right, Math.max(min, root.val), max);
        //left right subtrees are BST
        if (!left || !right) {
            return false;
        }
        //current min < root.val < current max
        if (min < root.val && max > root.val) {
            return true;
        }
        return false;
    }
}