/*
Write an efficient algorithm that searches for a value in an m x n matrix.

This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Have you met this question in a real interview? Yes
Example
Consider the following matrix:

[
    [1, 3, 5, 7],
    [10, 11, 16, 20],
    [23, 30, 34, 50]
]
Given target = 3, return true.
http://www.lintcode.com/en/problem/search-a-2d-matrix/#
*/


public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        int col = matrix[0].length; //get col
        int row = matrix.length;  //get row
        int start = 0;
        int end = row*col-1;
        while (start <= end) {
            int mid = start+(end-start)/2;
            if (matrix[mid/col][mid%col] < target) {
                start = mid+1;
            } else if (matrix[mid/col][mid%col] > target) {
                end = mid-1;
            } else {
                return true;
            }
        }
        return false;
    }
}
