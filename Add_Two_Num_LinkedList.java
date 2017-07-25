/*

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
https://leetcode.com/problems/add-two-numbers/#/description
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode befResult = new ListNode(0);
        ListNode cur = befResult;
        int carryOut = 0;
        while(node1 != null && node2 != null) {
            ListNode newNode = new ListNode((node1.val+node2.val+carryOut)%10);
            carryOut = (node1.val+node2.val+carryOut)/10;
            node1 = node1.next;
            node2 = node2.next;
            cur.next = newNode;
            cur = cur.next;
            }
        
        while(node1!=null) {
            ListNode newNode = new ListNode((node1.val+carryOut)%10);
            carryOut = (node1.val+carryOut)/10;
            node1 = node1.next;
            cur.next = newNode;
            cur = cur.next;
        }
        while(node2!=null) {
            ListNode newNode = new ListNode((node2.val+carryOut)%10);
            carryOut = (node2.val+carryOut)/10;
            node2 = node2.next;
            cur.next = newNode;
            cur = cur.next;
        }
        if(carryOut!=0) {
            ListNode newNode = new ListNode(carryOut);
            cur.next = newNode;
        }
     return befResult.next;
}
}

/*
Hints:
set cur pointing to head and move next: must make head point to an object first(not null) 
side cases: carryOut is not 0 at the end of the process