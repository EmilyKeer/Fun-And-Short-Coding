/*
Given a rotated sorted array, recover it to sorted array in-place.

Clarification
What is rotated array?

For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
Example
[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
*/
/*
Since the whole reverse process is O(n), no need to save time for traverse to see
offset
*/

public class Solution {
    /*
     * @param nums: An integer
     * @return: 
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return;
        }
        for (int i=0; i<nums.size()-1; i++) {
            if (nums.get(i) > nums.get(i+1)) {
                reverse(nums, 0, i);
                reverse(nums, i+1, nums.size()-1);
                reverse(nums, 0, nums.size()-1);
                return;
            }
        }
    }
    
    private void reverse(List<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++; // do not forget
            end--;
        }
    }
}