package MidsemFuncs;

public class integer {
  private static int a = 10;

  static {
    System.out.println("hash" + Integer.valueOf(a).hashCode());
    System.out.println("leadzero" + Integer.numberOfLeadingZeros(a));
    System.out.println("trailzero" + Integer.numberOfTrailingZeros(a));
    System.out.println("reverse" + Integer.reverse(a)); // like in digital design
  }

  @Override
  public String toString() {
    return "integer{" +
        "a=" + a +
        '}';
  }
}