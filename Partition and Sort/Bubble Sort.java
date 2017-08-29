boolean swap = false;
for (int i = 0; i < A.length - 1; i++) {
  for (int j = 0; j < A.length - 1 - i; j++) {
    if (A[j] > A[j + 1]) {
      int temp = A[j];
      A[j] = A[j + 1];
      A[j + 1] = temp;
      swap = true;
    }
  }
  if (swap == true) {
    swap = false;
  } else {
    break;
  }
}
