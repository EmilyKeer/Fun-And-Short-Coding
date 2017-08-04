/*
Given a big sorted array with positive integers sorted by ascending order. The array is so big so that you can not get the length of the whole array directly, and you can only access the kth number by ArrayReader.get(k) (or ArrayReader->get(k) for C++). Find the first index of a target number. Your algorithm should be in O(log k), where k is the first index of the target number.

Return -1, if the number doesn't exist in the array.

 Notice

If you accessed an inaccessible index (outside of the array), ArrayReader.get will return 2,147,483,647.

Example
Given [1, 3, 6, 9, 21, ...], and target = 3, return 1.

Given [1, 3, 6, 9, 21, ...], and target = 4, return -1.

http://www.lintcode.com/en/problem/search-in-a-big-sorted-array/#
*/

/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        if (reader == null || reader.get(0) == -1) {
            return -1;
        }
        int upBound = 1;
        while (reader.get(upBound-1) < target) {
            upBound = upBound * 2;
        } //log(k)
        int start = 0; 
        int end = upBound-1;
        while (start+1 < end) {
            int mid = (start+end)/2;
            if (reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (reader.get(start) == target) {
            return start;
        } 
        if (reader.get(end) == target) {
            return end;
        }
        return -1;
        
    }
}