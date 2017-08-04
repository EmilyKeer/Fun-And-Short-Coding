/*
Given a target number and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to the given target.

Return -1 if there is no element in the array.

 Notice

There can be duplicate elements in the array, and we can return any of the indices with same value.

Example
Given [1, 2, 3] and target = 2, return 1.

Given [1, 4, 6] and target = 3, return 1.

Given [1, 4, 6] and target = 5, return 1 or 2.

Given [1, 3, 3, 4] and target = 2, return 0 or 1 or 2

http://www.lintcode.com/en/problem/closest-number-in-sorted-array/#
*/

/*
Hint:
1. do binary search to narrow down to [left, right]
2. case: left==target, right==target, abs(target-left, right-target)
3. null, empty, all smaller, all larger
*/

//Binary search
/*
Whatever kind of narrrowing down, it will reach a state when:
[left, right] with 3 possibilities

in the following case, only need to find existing or not, so mid+1 mid-1
*/
public boolean binarySearch(int key) 
5    {
6         int low = 0;
7         int high = size - 1;
8          
9         while(high >= low) { //stop rule
10             int middle = (low + high) / 2;
11             if(data[middle] == key) {
12                 return true;
13             }
14             if(data[middle] < key) {
15                 low = middle + 1;
16             }
17             if(data[middle] > key) {
18                 high = middle - 1;
19             }
20        }
21        return false;
22   }

//Binary search to find the closest number
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        if (target < A[0]) {
            return 0;
        }
        if (target > A[A.length-1]) {
            return A.length-1;
        }
        int num = search(A, target);
        if (num == 0) {
            return 0;
        }
        if (target-A[num-1] < A[num]-target) {
            return num-1;
        }
        return num;
    }
    private int search (int[] A, int target) {
        int start = 0;
        int end = A.length-1;
        while(start+1 < end) {
            int mid = start+(end-start)/2;
            if (A[mid] < target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            } else {
                end = mid;
            }
        }
        return end;
    }
}

