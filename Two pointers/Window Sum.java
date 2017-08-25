/*
Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, find the sum of the element inside the window at each moving.

Example
For array [1,2,7,8,5], moving window size k = 3. 
1 + 2 + 7 = 10
2 + 7 + 8 = 17
7 + 8 + 5 = 20
return [10,17,20]
*/

public class Solution {
    /**
     * @param nums a list of integers.
     * @return the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0 || k>nums.length) {
            return new int[0];
        }
        int[] result = new int[nums.length-k+1];
        int index = 0;
        int start = 0;
        int end = k-1;
        int sum = 0;
        
        for (int i=start; i<=end; i++) {
            sum += nums[i];
        }
        result[index] = sum;
        index++;
        while(end < nums.length-1) {
            sum -= nums[start];
            start++;
            end++;
            sum += nums[end];
            result[index] = sum;
            index++;
        }
        return result;
    }
}

