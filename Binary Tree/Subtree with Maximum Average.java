/*
Given a binary tree, find the subtree with maximum average. Return the root of the subtree.

Example
Given a binary tree:

     1
   /   \
 -5     11
 / \   /  \
1   2 4    -2 
return the node 11.


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
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    public class ResultType {
    public int sum;
    public int size;
    public ResultType(int sum, int size) {
        this.sum = sum;
        this.size = size;
    }
    }
    public ResultType targetResult = new ResultType(Integer.MIN_VALUE, 1);
    public TreeNode target = null;
    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }
        helper(root);
        return target;
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0,0);
        }
        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);
        ResultType rootResult = new ResultType(leftResult.sum+root.val+rightResult.sum, leftResult.size+1+rightResult.size);
        if ((1.0*rootResult.sum)/rootResult.size > (1.0*targetResult.sum)/targetResult.size) {
            targetResult = rootResult;
            target = root;
        }
        return rootResult;
    }
}