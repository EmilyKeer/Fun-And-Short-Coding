/*
Given a undirected graph, a node and a target, return the nearest node to given node which value of it is target, return NULL if you can't find.

There is a mapping store the nodes' values in the given parameters.

 Notice

It's guaranteed there is only one available solution

Example
2------3  5
 \     |  | 
  \    |  |
   \   |  |
    \  |  |
      1 --4
Give a node 1, target is 50

there a hash named values which is [3,4,10,50,50], represent:
Value of node 1 is 3
Value of node 2 is 4
Value of node 3 is 10
Value of node 4 is 50
Value of node 5 is 50

Return node 4
*/

/*
check itself; check neighbors; ...
BFS template
*/

/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */

//Initial solution with duplicate nodes in queue when checking
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // Write your code here
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode checkNode = queue.poll();
            if (values.get(checkNode) == target) {
                return checkNode;
            }
            for (int i=0; i<checkNode.neighbors.size(); i++) {
                queue.offer(checkNode.neighbors.get(i));
            }
        }
        return null;
    }
}

//use set to get rid of duplicate nodes in queue
public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // Write your code here
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Set<UndirectedGraphNode> hash = new HashSet<UndirectedGraphNode>();
        queue.offer(node);
        hash.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode checkNode = queue.poll();
            if (values.get(checkNode) == target) {
                return checkNode;
            }
            for (UndirectedGraphNode nei : checkNode.neighbors) {
                if (!hash.contains(nei)) {
                    queue.offer(nei);
                    hash.add(nei);
                }
            }
        }
        return null;
    }