/*
Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.

If the given node has no in-order successor in the tree, return null.
*/

//Keer's Solution O(N)

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
    private int flag=0;
    private TreeNode result = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
      visit(root, p, flag);
      return result;
    }
    
    private void visit (TreeNode root, TreeNode p, int flag) {
        if(root!=null) {
            visit(root.left, p, flag);
        if(check(root, p)) {
                result = root;
            }
            visit(root.right, p ,flag);
        }
    }
    
    private boolean check(TreeNode root, TreeNode p) {
        if (root == p) {
            flag = 1;
        }
        else if(flag == 1) {
            flag = 0;
            return true;
        }
        return false;
    }
}


//better solution O(log(N))
/*
if(p.val < root.val):
 check left;
if(p == root):
 if root.right == null: return successor
 else: go all the way left down root.right to the last node
if (p.val > root.val)
 check right;
*/
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null && root != p) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        
        if (root == null) {
            return null;
        }
        
        if (root.right == null) {
            return successor;
        }
        
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        
        return root;
    }
}

//version2
public class Solution {
    TreeNode successor = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root!=null) {
            if (p.val < root.val) {
                successor = root;
                return inorderSuccessor(root.left, p);
            }
            else if (p == root) {
                if (root.right!=null) {
                    TreeNode result = root.right;
                    while(result.left!=null) {
                        result = result.left;
                    }
                    return result;
                } else {
                    return successor;
                }
            }
            else {
                return inorderSuccessor(root.right, p);
            }
        }
        else {
            return null;
        }
    }
}

// version3
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null || p == null) {
            return null;
        }

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        }
    }
}
