/*
Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.

 Notice

LintCode will print the subtree which root is your return node.
It's guaranteed that there is only one subtree with minimum sum and the given binary tree is not an empty tree.

Example
Given a binary tree:

     1
   /   \
 -5     2
 / \   /  \
0   2 -4  -5 
return the node 1.
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
     * @return the root of the minimum subtree
     */
    public int sum = Integer.MAX_VALUE;
    public TreeNode target = null;
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        getSum(root);
        return target;
        
    }
    private int getSum(TreeNode root) {
        if (root == null) {
            return 0; //consider leaf node
        }
        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);
        int rootSum = leftSum+rightSum+root.val;
        if (rootSum < sum) {
            sum = rootSum;
            target = root;
        }
        return rootSum;
    }
}