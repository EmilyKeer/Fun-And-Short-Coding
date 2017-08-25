/*
Given an array of integers, remove the duplicate numbers in it.

You should:
1. Do it in place in the array.
2. Move the unique numbers to the front of the array.
3. Return the total number of the unique numbers.

 Notice

You don't need to keep the original order of the integers.

Example
Given nums = [1,3,1,4,4,2], you should:

Move duplicate integers to the tail of nums => nums = [1,3,4,2,?,?].
Return the number of unique integers in nums => 4.
Actually we don't care about what you place in ?, we only care about the part which has no duplicate integers.
*/

//Queue and Set: preserve orders
/*
1.Queue to store spaces to be filled
2.Set<Integer> set = new HashSet<Integer>()  --> some.contains
*/

public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Queue queue = new LinkedList();
        Set<Integer> existedNums = new HashSet<Integer>();
        int count = 0;
        int putIndex = 0;
        for (int i=0; i<nums.length; i++) {
            if(existedNums.contains(nums[i])) {
                queue.offer(i);
                continue;
            }
            if (!queue.isEmpty()) {
                putIndex = (int)queue.poll();
                nums[putIndex] = nums[i];
                queue.offer(i);
            }
            existedNums.add(nums[i]);
            count++;
        }
        return count;
    }
}

//No need to preserve order
public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Boolean> mp = new HashMap<Integer, Boolean>();
        for (int i=0; i<nums.length; i++) {
            mp.put(nums[i], true);
        }
        int count = 0;
        for(Map.Entry<Integer, Boolean> each : mp.entrySet()) {
            nums[count] = each.getKey(); //just like Set
            count++;
        }
        return count;
    }
}
