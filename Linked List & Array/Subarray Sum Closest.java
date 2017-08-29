/*
Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.

Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
*/

/*
prefix sum
问：为什么需要一个 (0,0) 的初始 Pair?
答：
比如对于数组 [1,2,3,4]，他的 Prefix Sum 是 [1,3,6,10]
分别表示 前1个数之和，前2个数之和，前3个数之和，前4个数之和
这个时候如果你想要知道 子数组 从下标  1 到下标 2 的这一段的和(2+3)，就用前 3个数之和 减去 前1个数之和 = PrefixSum[2] - PrefixSum[0] = 6 - 1 = 5
你可以看到这里的 前 x 个数，和具体对应的下标之间，存在 +-1 的问题
第 x 个数的下标是 x - 1，反之 下标 x 是第 x + 1 个数
那么问题来了，如果要计算 下标从 0~2 这一段呢？也就是第1个数到第3个数，因为那样会访问到 PrefixSum[-1]
所以我们把 PrefixSum 整体往后面移动一位，把第0位空出来表示前0个数之和，也就是0. => [0,1,3,6,10]
那么此时就用 PrefixSum[3] - PrefixSum[0] ，这样计算就更方便了。
此时，PrefixSum[i] 代表 前i个数之和，也就是 下标区间在 0 ~ i-1 这一段的和

那么回过头来看看，为什么我们需要一个 (0,0) 的 pair 呢？
因为 这个 0,0 代表的就是前0个数之和为0
一个 n 个数的数组， 变成了 prefix Sum 数组之后，会多一个数出来

*/
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public class Pair {
        int idx;
        int sum;
        public Pair(int idx, int sum) {
            this.idx = idx;
            this.sum = sum;
        }
    }
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[2];
        }
        if (nums.length == 1) {
            return new int[] {0, 0};
        }
        Pair[] sums = new Pair[nums.length + 1]; //sums[0] (0,0) dummy node
        sums[0] = new Pair(0, 0);
        int preSum = 0;
        for (int i = 1; i <= nums.length; i++) { //index+1
            sums[i] = new Pair(i, preSum + nums[i - 1]);
            preSum += nums[i - 1];
        }
        Arrays.sort(sums, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                return p1.sum - p2.sum;
            }
            });
        int[] ans = new int[2];
        int closestSum = Integer.MAX_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            if (sums[i].sum - sums[i - 1].sum < closestSum) {
                closestSum = sums[i].sum - sums[i - 1].sum;
                int[] temp = new int[]{sums[i].idx - 1, sums[i - 1].idx - 1};
                Arrays.sort(temp); //must do
                ans[0] = temp[0] + 1;
                ans[1] = temp[1];
            }
        }
        return ans;
    }
}
