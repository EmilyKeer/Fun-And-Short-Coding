/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example
Given binary tree A = {3,9,20,#,#,15,7}, B = {3,#,20,15,7}

A)  3            B)    3 
   / \                  \
  9  20                 20
    /  \                / \
   15   7              15  7
The binary tree A is a height-balanced binary tree, but B is not.
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
     * @return: True if this Binary tree is Balanced, or false.
     * 
     * Hint: 1. left right balance; 2. left right differ <= 1
     */
    public class ReturnType {
        boolean isBalanced;
        int height;
        ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
    public boolean isBalanced(TreeNode root) {
        // write your code here
        ReturnType result = helper(root);
        return result.isBalanced;
        
    }
    private ReturnType helper (TreeNode root) {
        if (root == null) {
            return new ReturnType(true, 0);
        }
        ReturnType leftResult = helper(root.left);
        ReturnType rightResult = helper(root.right);
        if (!leftResult.isBalanced) {
            return new ReturnType(false, -1);
        }
        if (!rightResult.isBalanced) {
            return new ReturnType(false, -1);
        }
        if (Math.abs(leftResult.height-rightResult.height) > 1) {
            return new ReturnType(false, -1);
        }
        return new ReturnType(true, Math.max(leftResult.height, rightResult.height)+1);
    }
}