/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

Hint:
1. process: new Node(value) --> what if presented before? --> HashMap
2. first node: dummy node
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        HashMap<RandomListNode, RandomListNode> existedMap = new HashMap<RandomListNode, RandomListNode>();
        while(head != null) {
            RandomListNode newNode;
            if (existedMap.containsKey(head)) {
                newNode = existedMap.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                existedMap.put(head, newNode);
            }
            if (head.random != null) {
                if (existedMap.containsKey(head.random)) {
                    newNode.random = existedMap.get(head.random);
                } else {
                    newNode.random = new RandomListNode(head.random.label);
                    existedMap.put(head.random, newNode.random);
                }
            }
            pre.next = newNode;
            pre = newNode;
            head = head.next;
        }
        return dummy.next;
    }
}