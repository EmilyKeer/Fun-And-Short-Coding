/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Notice

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

The solution set must not contain duplicate triplets.

Example
For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

(-1, 0, 1)
(-1, -1, 2)

public class Solution {
    /*
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> triplets = new ArrayList<List<Integer>>();
        if (numbers == null || numbers.length < 3) {
            return triplets;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (numbers[i] > 0) {
                return triplets;
            }
            if (i > 0 && numbers[i] == numbers[i-1]) {
                continue;
            }
            storeTriplets(numbers, i+1, numbers.length-1, -numbers[i], triplets);
        }
        return triplets;
    }
    
    private void storeTriplets(int[] numbers, int start, int end, int target, List<List<Integer>> result) {
        while(start < end) {
            int tempSum = numbers[start] + numbers[end];
            if(tempSum < target) {
                start++;
            } else if (tempSum == target) {
                result.add(new ArrayList<Integer>(Arrays.asList(-target, numbers[start], numbers[end])));
                start++;
                end--;
                while(start < end && numbers[start] == numbers[start-1]) {
                    start++;
                }
                while(start < end && numbers[end] == numbers[end+1]) {
                    end--;
                }
            } else {
                end--;
            }
        }
    }
}
*/

