/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.

[show hint]

Hint:
Could you do it in-place with O(1) extra space?
https://leetcode.com/problems/rotate-array/description/

Hint:
think about like this:

Let the array be - 123456789 and k = 4

Step 1 - 12345 6789 ---> 54321 6789

Step 2 - 54321 6789 ---> 54321 9876

Step 3 - 543219876 ---> 678912345

*/

//reverse in for loop
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n; //you can think more about negative case and how Java handles it
        if (k > 0) {
        reverse(nums, 0, n-1); //always check out of bound; check 0
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
        }
    }
    private void reverse(int[] nums, int start, int end) {
        for (int i=start; i<=start+(end-start)/2; i++) {
            int temp = nums[i];
            nums[i] = nums[end-(i-start)];
            nums[end-(i-start)] = temp;
        }
    }
}

//use while loop for start and end: easy
 private void reverse(int[] nums, int start, int end) {
        while(start<end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }