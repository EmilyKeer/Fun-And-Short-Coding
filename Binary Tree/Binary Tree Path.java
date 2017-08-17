/*
Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.

A valid path is from root node to any of the leaf nodes.

Have you met this question in a real interview? Yes
Example
Given a binary tree, and target = 5:

     1
    / \
   2   4
  / \
 2   3
return

[
  [1, 2, 2],
  [1, 4]
]

*/

/*
Idea:
keep track of current sum and path, will go thro all paths
for each root: get left paths and right paths and then add and update

Careful:
for (Type each : someList) ... someList cannot be null; should be ArrayList<>()
List<> something = new ArrayList<>();
List<List<Integer>> something = new ArrayList<List<Integer>>;
Think clearly about naming.
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
     * @param target an integer
     * @return all valid paths
     */
    public class SumAndPath {
        int sum;
        List<Integer> path;
        SumAndPath(int sum, List<Integer> path) {
            this.sum = sum;
            this.path = path;
        }
    }
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
      
        List<SumAndPath> preResult = getSumAndPath(root);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (SumAndPath each : preResult) {
            if (each.sum == target) {
                result.add(each.path);
            }
        }
        return result;
        
    }
    private List<SumAndPath> getSumAndPath(TreeNode root) {
        if (root == null) {
            return new ArrayList<SumAndPath>();
        }
        if (root.left == null && root.right == null) {
            SumAndPath sumAndPath = new SumAndPath(root.val, new ArrayList<Integer>(Arrays.asList(root.val)));
            return new ArrayList<SumAndPath>(Arrays.asList(sumAndPath));
        }
        List<SumAndPath> leftSumAndPath = getSumAndPath(root.left);
        List<SumAndPath> rightSumAndPath = getSumAndPath(root.right);
        List<SumAndPath> rootSumAndPath = new ArrayList<SumAndPath>();
        for (SumAndPath each : leftSumAndPath) {
            List<Integer> pathList = new ArrayList<Integer>();
            pathList.add(root.val);
            pathList.addAll(each.path);
            SumAndPath sumAndPath = new SumAndPath(each.sum+root.val, pathList);
            rootSumAndPath.add(sumAndPath);
        }
        for (SumAndPath each : rightSumAndPath) {
            List<Integer> pathList = new ArrayList<Integer>();
            pathList.add(root.val);
            pathList.addAll(each.path);
            SumAndPath sumAndPath = new SumAndPath(each.sum+root.val, pathList);
            rootSumAndPath.add(sumAndPath);
        }
        return rootSumAndPath;
    }
}