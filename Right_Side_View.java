/* 
https://leetcode.com/problems/binary-tree-right-side-view/#/description
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
*/

//hit level check
/*
using global var hitLevel(hit the level yet?)
go from mid right to left (right subtree first then left subtree)
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
    private int hitLevel = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<Integer> ();
        checkEachLevel(root, 1, rightSide);
        return rightSide;
    }
    private void checkEachLevel (TreeNode root, int level, List<Integer> rightSide) {
        if (root == null) {
            return;
        }
        if (hitLevel < level) {
            rightSide.add(root.val);
            hitLevel ++;
        }
        checkEachLevel (root.right, level+1, rightSide);
        checkEachLevel (root.left, level+1, rightSide);
    }
}

//using DFS
/*
dfs: level 1234... from left to right at each level
HashMap<Integer, Integer> : put can refresh value
convert Collection map.values() to Arraylist
*/
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer, Integer> result = new HashMap<Integer, Integer> ();
        dfs(root, 1, result);
        List<Integer> rightSide = new ArrayList<Integer>(result.values());
        return rightSide;
    }
    private void dfs (TreeNode root, int depth, HashMap<Integer, Integer> result) {
        if (root == null) {
            return;
        }
        result.put(depth, root.val);
        dfs(root.left, depth+1, result);
        dfs(root.right, depth+1, result);
    }
}



