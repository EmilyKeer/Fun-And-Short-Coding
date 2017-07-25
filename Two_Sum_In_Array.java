/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

https://leetcode.com/problems/two-sum/#/description
*/


public class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i=0; i<nums.length-1; i++) {

                int j = i+1;
                while(j<nums.length) {
                    if(nums[i] + nums[j] == target) {
                        return new int[] {i,j};
                    }
                    j++;
                }
        }
        return null;
    }
}

/* 
take care of:
nums can be negative!
0+0=0
-3+3=0
so cannot compare single <= target first
*/