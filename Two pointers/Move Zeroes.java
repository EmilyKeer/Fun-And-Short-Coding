/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 Notice

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
Example
Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
*/

public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int fillIndex = 0;
        int count = 0;
        Queue queue = new LinkedList();
        for (int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                queue.offer(i);
                count++;
                continue;
            }
            if (!queue.isEmpty()) {
                fillIndex = (int)queue.poll();
                nums[fillIndex] = nums[i];
                queue.offer(i);
            }
            
        }
        for (int i=nums.length-count; i<nums.length; i++) {
            nums[i] = 0;
        }
        
    }
}