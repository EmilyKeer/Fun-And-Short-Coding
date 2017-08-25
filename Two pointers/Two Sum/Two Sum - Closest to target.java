/*
Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.

Return the difference between the sum of the two integers and the target.

Example
Given array nums = [-1, 2, 1, -4], and target = 4.

The minimum difference is 1. (4 - (2 + 1) = 1).
*/

public class Solution {
    /*
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        while(start < end) {
            int tempSum = nums[start] + nums[end];
            if(tempSum == target) {
                return 0;
            }
            if (tempSum < target) {
                int abs = Math.abs(tempSum - target);
                diff = Math.min(diff, abs);
                start++;
            } else {
                int abs = Math.abs(tempSum - target);
                diff = Math.min(diff, abs);
                end--;
            }
        }
        return diff;
    }
}