/*Given a set of distinct integers, return all possible subsets.

 Notice

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Have you met this question in a real interview? Yes
Example
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
http://www.lintcode.com/en/problem/subsets/#
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (nums == null) return result;
        Arrays.sort(nums);
        result.add(new ArrayList<Integer>());
        result = helper(nums, 0, result);
        return result;
    }
    private ArrayList<ArrayList<Integer>> helper(int[]nums, int pos, ArrayList<ArrayList<Integer>> inSubset) {
        if(pos == nums.length) return inSubset;
        ArrayList<ArrayList<Integer>> curSubset = new ArrayList<>(inSubset);

        for (ArrayList<Integer> eachSet : inSubset) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(eachSet); //add all elements from eachSet to temp, diff "pointer"
            temp.add(nums[pos]);
            curSubset.add(temp);
        }
        return helper(nums, pos+1, curSubset);
    }
}
