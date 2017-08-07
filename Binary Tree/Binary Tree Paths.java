/*
Given a binary tree, return all root-to-leaf paths.

Example
Given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

[
  "1->2->5",
  "1->3"
]

http://www.lintcode.com/en/problem/binary-tree-paths/#
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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> rootPaths = new ArrayList<String>(); //should ArrayList
        if (root == null) {
            return rootPaths;
        }
        
        if (root.left == null && root.right == null) {
            rootPaths.add(""+root.val);
            return rootPaths;
        }
        
        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String path : leftPaths) { //if leftPaths is empty list: will not enter for loop
            String result = root.val+"->"+path; //path cannot be null (literally null)
            rootPaths.add(result);
        }
        for (String path : rightPaths) {
            String result = root.val+"->"+path;
            rootPaths.add(result);
        }
        return rootPaths;
    }
}