/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
https://leetcode.com/problems/binary-tree-level-order-traversal/#/description
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int height = getHeight(root);
        for(int i=1; i<=height; i++) {
            List<Integer> eachLevel = new ArrayList<Integer>();
            checkEachLevel(eachLevel, i, root);
            result.add(eachLevel);
        }
        return result;
    }
    private void checkEachLevel(List<Integer> eachLevel, int level, TreeNode node) {
        if (node == null) {return;}
        if (level == 1) {
        eachLevel.add(node.val);
        }
        else{
            checkEachLevel(eachLevel, level-1, node.left);
            checkEachLevel(eachLevel, level-1, node.right);
        }

    }
    private int getHeight(TreeNode root) {
        if (root==null) {return 0;}
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(left<right) {
            return right+1;
        } else {
            return left+1;
        }
    }
}

//for bottom up:
Collections.reverse(result);