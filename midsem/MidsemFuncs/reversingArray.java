package MidsemFuncs;

public class reversingArray {
  private int[] arr;

  public reversingArray(int arr[]) {
    this.arr = arr;
  }

  public int[] reverse() {
    for (int i = 0; i < arr.length / 2; i++) {
      swap(i, arr.length - i - 1);
    }
    return arr;
  }

  public int[] swap(int posA, int posB) {
    int temp = this.arr[posA];
    this.arr[posA] = this.arr[posB];
    this.arr[posB] = temp;
    return this.arr;
  }
}