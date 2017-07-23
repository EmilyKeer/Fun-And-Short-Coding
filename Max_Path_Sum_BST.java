/*
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.


Hint:
For one node, its max sum path:
node.left max path + node + node.right max path
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
    int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        int holder = maxPathOneSide(root);
        return maxValue;
        
    }
    private int maxPathOneSide(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, maxPathOneSide(root.left));
        int right = Math.max(0, maxPathOneSide(root.right));
        maxValue = Math.max(maxValue, left+right+root.val);
        //return Math.max(0, Math.max(left, right)+root.val);
        return Math.max(left, right)+root.val;
        //consider: if all the nodes are negative; it will return the "largest" negative
        //node value
    }
}