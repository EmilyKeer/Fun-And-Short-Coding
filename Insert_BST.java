/*
Given a binary search tree and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.

 Notice

You can assume there is no duplicate values in this tree + node.
*/

//Solution without recursion
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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            root = node;
        } else {
           TreeNode cur = root;
        while(cur != null) {
            if (node.val < cur.val) {
                if(cur.left != null) {
                    cur = cur.left;
                } else {
                    cur.left = node;
                    break;
                }
            }
            if (node.val > cur.val) {
                if (node.val > cur.val) {
                    if (cur.right != null) {
                        cur = cur.right;
                    } else {
                        cur.right = node;
                        break;
                    }
                }
            }
        } 
        }
        
        return root;
    }
}

//solution with recursion
/*
Note:
to return the TreeNode root, one can:
root.left = function(..)
root.right = function(..)
*/
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (root == null) {
            root = node;
        }
        if (node.val < root.val) {
            root.left = insertNode(root.left, node);
        }
        else if (node.val > root.val) {
            root.right = insertNode(root.right, node);
        }
        return root;
        
    }
}