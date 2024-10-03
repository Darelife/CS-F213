import MidsemFuncs.reversingArray;

public class midsem {
  public static void main(String[] args) {
    int arr[] = new int[] { 1, 2, 3, 4, 5 };
    System.out.println("Original array after reverse method call:");
    for (int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + " ");
    reversingArray ra = new reversingArray(arr);
    int arr2[] = ra.reverse();
    System.out.println();
    System.out.println("Reversed array:");
    for (int i = 0; i < arr2.length; i++)
      System.out.print(arr2[i] + " ");
  }
}