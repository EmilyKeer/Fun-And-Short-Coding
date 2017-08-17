/*
Given a target number and an integer array sorted in ascending order. Find the total number of occurrences of target in the array.

Example
Given [1, 3, 3, 4, 5] and target = 3, return 2.

Given [2, 2, 3, 4, 6] and target = 4, return 1.

Given [1, 2, 3, 4, 5] and target = 6, return 0.
*/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length-1;
        while (start+1 < end) {
            int mid = start+(end-start)/2;
            if (target <= A[mid]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int first = 0;
        if (A[start] == target) {
            first = start;
        } else if (A[end] == target) {
            first = end;
        } else {
            return 0;
        }
        int count = 0;
        int elem = first;
        while(elem<A.length && A[elem] == target) {
            count++;
            elem++;
        }
        return count;
    }
}