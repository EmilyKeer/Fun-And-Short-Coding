/*
Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.

 Notice

There is at least one subarray that it's sum equals to zero.

Example
Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
*/

//Stupid use of HashMap: traverse

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        HashMap<Integer, Integer> perSubSum = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                return new ArrayList<Integer>(Arrays.asList(i, i));
            }
            for (Integer key : perSubSum.keySet()) {
                int tempSum = perSubSum.get(key)+nums[i];
                if (tempSum == 0) {
                    return new ArrayList<Integer>(Arrays.asList(key, i));
                }
                perSubSum.put(key, tempSum);
            }
            perSubSum.put(i, nums[i]);
        }
        return new ArrayList<Integer>();
    }
}

//correct use of HashMap: containsKey
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        HashMap<Integer, Integer> perSubSum = new HashMap<Integer, Integer>();
        int sum = 0;
        perSubSum.put(0, -1); //if nums[0] == 0
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (perSubSum.containsKey(sum)) {
                return new ArrayList<Integer>(Arrays.asList(perSubSum.get(sum)+1, i));
            }
            perSubSum.put(sum, i);
        }
        return new ArrayList<Integer>();
    }
}

