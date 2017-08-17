/*
There is an integer array which has the following features:

The numbers in adjacent positions are different.
A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
We define a position P is a peek if:

A[P] > A[P-1] && A[P] > A[P+1]
Find a peak element in this array. Return the index of the peak.

 Notice

The array may contains multiple peeks, find any of them.

Example
Given [1, 2, 1, 3, 4, 5, 7, 6]

Return index 1 (which is number 2) or 6 (which is number 7)
http://www.lintcode.com/en/problem/find-peak-element/#
*/ 

//O(n)
class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length < 3) {
            return -1;
        }
        for (int i=1; i<A.length-1; i++) {
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                return i;
            }
        }
        return -1;
    }
}

//O(logn)
/*
If num[i-1] < num[i] > num[i+1], then num[i] is peak
If num[i-1] < num[i] < num[i+1], then num[i+1...n-1] must contains a peak
If num[i-1] > num[i] > num[i+1], then num[0...i-1] must contains a peak
If num[i-1] > num[i] < num[i+1], then both sides have peak
(n is num.length)
*/

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int start = 0;
        int end = A.length-2;
        while (start+1 < end) {
            int mid = start+(end-start)/2;
            if (A[mid-1] > A[mid]) {
                end = mid;
            } else if (A[mid] < A[mid+1]) {
                start = mid;
            } else { //when mid is a peek
                end = mid; //keep end is possible
            }
        }
        if (A[start] < A[end]) { // get the larger one
            return end;
        } else {
            return start;
        }
    }
}

