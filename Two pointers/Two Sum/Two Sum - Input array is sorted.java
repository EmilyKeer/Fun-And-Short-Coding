/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 Notice

You may assume that each input would have exactly one solution.

Example
Given nums = [2, 7, 11, 15], target = 9
return [1, 2]
*/

public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int tempSum = nums[start] + nums[end];
            if (tempSum == target) {
                return new int[]{start + 1, end + 1};
            }
            if (tempSum < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[0];
    }
}