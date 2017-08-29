/*
Six degrees of separation is the theory that everyone and everything is six or fewer steps away, by way of introduction, from any other person in the world, so that a chain of "a friend of a friend" statements can be made to connect any two people in a maximum of six steps.

Given a friendship relations, find the degrees of two people, return -1 if they can not been connected by friends of friends.

Example
Gien a graph:

1------2-----4
 \          /
  \        /
   \--3--/
{1,2,3#2,1,4#3,1,4#4,2,3} and s = 1, t = 4 return 2

Gien a graph:

1      2-----4
             /
           /
          3
{1#2,4#3,4#4,2,3} and s = 1, t = 4 return -1
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        HashMap<UndirectedGraphNode, Integer> visited = new HashMap<UndirectedGraphNode, Integer>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        int step = 0;
        if (s == t) {
            return 0;
        }
        queue.offer(s);
        visited.put(s, step);
        while(!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();
            step = visited.get(node);
            for (UndirectedGraphNode each : node.neighbors) {
                if (visited.containsKey(each)) {
                    continue;
                }
                visited.put(each, step + 1);
                queue.offer(each);
                if (each == t) {
                    return step + 1;
                }
            }
        }
        return -1;
    }
}
