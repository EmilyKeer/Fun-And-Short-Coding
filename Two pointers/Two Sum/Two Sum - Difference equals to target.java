/*
Given an array of integers, find two numbers that their difference equals to a target value.
where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.

 Notice

It's guaranteed there is only one available solution

Example
Given nums = [2, 7, 15, 24], target = 5
return [1, 2] (7 - 2 = 5)
*/

/*
target can be negative or positive for difference;
note that return index, so sort should use Pair

*/
public class Solution {
    /*
     * @param nums an array of Integer
     * @param target an integer
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
     public class Pair {
         int idx;
         int num;
         Pair(int idx, int num) {
             this.idx = idx;
             this.num = num;
         }
     }
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        if (target < 0) {
            target = -target;
        }
        //Arrays.sort(nums); //sort will change index
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(i, nums[i]); //use new to construct Pair
        }
        Arrays.sort(pairs, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                return p1.num - p2.num;
            }
            });
        int j = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (j == i) { //for example: [1,0,1], 0
                j++;
            }
            while(j < nums.length && pairs[j].num - pairs[i].num < target) {
                j++;
            }
            if (j < nums.length && pairs[j].num - pairs[i].num == target) {
                int idx1 = pairs[i].idx;
                int idx2 = pairs[j].idx;
                if (idx1 > idx2) {
                    int temp = idx2;
                    idx2 = idx1;
                    idx1 = temp;
                }
                return new int[]{idx1 + 1, idx2 + 1};
            }
        }
        return new int[0];
}
}