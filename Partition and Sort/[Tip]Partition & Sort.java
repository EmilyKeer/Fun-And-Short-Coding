/*
Standard quick sort:
Every time partition: left side <= target, right side >= target;
there might be one element between "right" and "left"
*/
public void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] A, int start, int end) {
        if (start >= end) { //>= for standard quicksort
            return;
        }

        int left = start, right = end;
        // key point 1: pivot is the value, not the index
        int pivot = A[(start + end) / 2]; //out of while

        // key point 2: every time you compare left & right, it should be
        // left <= right not left < right
        while (left <= right) {
            // key point 3: A[left] < pivot not A[left] <= pivot
            //[1,1,1,1,1,1,1,1,1,2]
            while (left <= right && A[left] < pivot) {
                left++;
            }
            // key point 3: A[right] > pivot not A[right] >= pivot
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;

                left++;
                right--;
            }
        }
        //finally there might be one element between right and left
        quickSort(A, start, right);
        quickSort(A, left, end);
    }






/*
1. To find the index for a number after the array is sorted: (should be unique array);
2. All elements < k left, >= k right
*/

public int partitionArray(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int left = 0, right = nums.length - 1;
        while (left <= right) {

            while (left <= right && nums[left] < k) {
                left++;
            }

            //in partition quick sort will be > k
            while (left <= right && nums[right] >= k) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }
        return left; //always the first num >= k
    }


    /*
    Find the kth smallest number in an unsorted integer array.
    Each recursion:
      1. partition
      2. quickSelect the subarray including index k; or end->k->start
    */

    class Solution {
        /*
         * @param k an integer
         * @param nums an integer array
         * @return kth smallest element
         */
        public int kthSmallest(int k, int[] nums) {
            // write your code here
            if (nums == null || nums.length < k) {
                return 0;
            }
            return quickSelect(k - 1, 0, nums.length - 1, nums);

        }
        private int quickSelect(int tarIndex, int left, int right, int[] nums){
            if (left == right) { //will not be >=; cuz it is solved in the last recursion
                return nums[left];
            }
            int start = left;
            int end = right;
            int pivot = nums[(start + end) / 2]; //pivot ouside while
            while(start <= end) {
                while(start <= end && nums[start] < pivot) {
                    start++;
                }
                while(start <= end && nums[end] > pivot) {
                    end--;
                }
                if (start <= end) {
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                    start++;
                    end--;
                }
            }
            if (tarIndex <= end) {
                return quickSelect(tarIndex, left, end, nums);
            } else if (tarIndex >= start) {
                return quickSelect(tarIndex, start, right, nums);
            } else {
                return nums[tarIndex];
            }
        }
    }
//For Kth largest: return quickSelect(nums.length - k, 0, nums.length - 1, nums);

/*
Partition Array by Odd and Even
by cases
by odd Even
partition twice: sort colors
*/
//Partition Array by Odd and Even
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        if (nums == null || nums.length == 0) {
            return;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            while(start <= end && nums[start] % 2 == 1) {
                start++;
            }
            while(start <= end && nums[end] % 2 == 0) {
                end--;
            }
            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
}

//Sort colors
class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int partIndex = partition(nums, 0, nums.length - 1, 1);
        partition(nums, partIndex, nums.length - 1, 2);
    }
    private int partition(int[] nums, int start, int end, int pivot) {
        while(start <= end) {
            while(start <= end && nums[start] < pivot) {
                start++;
            }
            while(start <= end && nums[end] >= pivot) {
                end--;
            }
            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        return start;
    }
}
