/*
Given a mountain sequence of n integers which increase firstly and then decrease, find the mountain top.

Example
Given nums = [1, 2, 4, 8, 6, 3] return 8
Given nums = [10, 9, 8, 7], return 10

http://www.lintcode.com/en/problem/maximum-number-in-mountain-sequence/#
*/

//naive solution without binary search
public class Solution {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     */
    public int mountainSequence(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int max = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                break;
            }
        }
        return max;
    }
}