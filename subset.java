//subset
//tail recursion solution:
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ;
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

//inline recursion
/*
main: null array? empty array?(length==0)
helper:
1. objective: pass in a subset of nums, save all subsets containing the "subset" in result
2. one senario: 
in subset: [1]  (nums: [1,2,3,4])
result.add [1] (use copy)
for each element after 1,
	add in subset, say [1.2]
	do the same thing for [1,2]
	subset.remove last element so that you can continue next for loop

Special things to notice:
sort to get ascending order numbers
in this case, distinct numbers

*/
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        if (nums == null) return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        //result.add(new ArrayList<>());
        Arrays.sort(nums);
        helper(new ArrayList<Integer>(), 0, nums, result);
        return result;
    }
    private void helper(ArrayList<Integer> subset,int startPos, int[]nums, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<Integer>(subset));
        for (int i=startPos; i<nums.length; i++) {
            subset.add(nums[i]);
            helper(subset, i+1, nums, result);
            subset.remove(subset.size()-1); //remove the last element
        }
    }
}



//advanced
/*
Given a list of numbers that may has duplicate numbers, return all possible subsets

 Notice

Each element in a subset must be in non-descending order.
The ordering between two subsets is free.
The solution set must not contain duplicate subsets.
Have you met this question in a real interview? Yes
Example
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        if (nums == null) return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        //result.add(new ArrayList<>());
        Arrays.sort(nums);
        helper(new ArrayList<Integer>(), 0, nums, result);
        return result;
    }
    private void helper(ArrayList<Integer> subset,int startPos, int[]nums, ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<Integer>(subset));
        for (int i=startPos; i<nums.length; i++) {
            //case1: [1,2] [1,2]let out   case2: [1,2,2]do have to add
            if (i>0 && nums[i]==nums[i-1] && startPos<i) continue;
            subset.add(nums[i]);
            helper(subset, i+1, nums, result);
            subset.remove(subset.size()-1); //remove the last element
        }
    }
}