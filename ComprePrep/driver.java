class A {
  static int x = 1234;

  static class B {
    static int y = x++; // y is assigned the value of x (1234), then x is incremented (x becomes 1235).

    static class C {
      static int z = y++; // z is assigned the value of y (1234), then y is incremented (y becomes 1235).
    }
  }
}

public class driver {
  public static void main(String[] args) {
    System.out.println(A.B.y);
    System.out.println(A.B.C.z);
    System.out.println(A.B.y);
    A.x = 1;
    System.out.println(A.x);
    System.out.println(A.B.y);
    System.out.println(A.x);
    A.B.y = 2;
    System.out.println(A.B.C.z);
    System.out.println(A.B.y);
  }
}
