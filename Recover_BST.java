/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

Hint:
1. One important thing about BST:
inOrder traverse will lead to a sorted array in ascending order
2. can use global TreeNode to keep tack of
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    TreeNode firstEle = null;
    TreeNode secEle = null;
    TreeNode lastEle = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        if (root != null) {
            traverse(root);
            int temp;
            temp = firstEle.val;
            firstEle.val = secEle.val;
            secEle.val = temp;
        }
    }
    private void traverse(TreeNode root) {
        if(root != null) {
            traverse(root.left);
            if(firstEle == null && lastEle.val > root.val) {
                firstEle = lastEle;
            }
            if (firstEle != null && lastEle.val > root.val) {
                secEle = root;
            }
            lastEle = root;
            traverse(root.right);
        }
        
    }
}