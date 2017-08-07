/*
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
Return null if LCA does not exist.

 Notice

node A or node B may not exist in tree.

Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7
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
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    boolean presentA = false;
    boolean presentB = false;
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        TreeNode result = presentNode(root, A, B);
        if (presentA && presentB) {
            return result;
        } 
        return null;
        
    }
    //return the presence of A, B, LCA, null
    /*
    if find A: return A
    if find B: return B
    if find LCA: return LCA
    others: null
    
    Consider: LCA is A or B
    */
    private TreeNode presentNode(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }
        TreeNode left = presentNode(root.left, A, B);
        TreeNode right = presentNode(root.right, A, B);
        
        if (root == A || root == B) {
            if (root == A) presentA = true;
            if (root == B) presentB = true;
            return root;
        }
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }
}