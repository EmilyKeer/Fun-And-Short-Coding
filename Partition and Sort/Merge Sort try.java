public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
      int[] temp = new int[A.length];
      mergeSort(A, 0, A.length - 1, temp);
    }

    private mergeSort(int[] A, int start, int end, int[] temp) {
      if (start >= end) {
        return;
      }
      int mid = start + (end - start) / 2;
      mergeSort(A, start, mid, temp);
      mergeSort(A, mid + 1, end, temp);
      int pointer1 = start;
      int pointer2 = mid + 1;
      int index = 0;
      while(pointer1 <= mid && pointer2 <= end) {
        if (A[pointer1] <= A[pointer2]) {
          temp[index] = A[pointer1];
          index++;
          pointer1++;
        } else {
          temp[index] = A[pointer2];
          index++;
          pointer2++;
        }
      }
      while(pointer1 <= mid) {
        temp[index] = A[pointer1];
        index++;
        pointer1++;
      }
      while(pointer2 <= end) {
        temp[index] = A[pointer2];
        index++;
        pointer2++;
      }
      for (int i = start; i <= end; i++) {
        A[i] = temp[i];
      }
    }
}
