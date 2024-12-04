import java.util.Arrays;
import java.util.Collection;

public class Rectangle extends Shape {
  private double width, height, x, y;

  public Rectangle() {
    // super("Rectangle");
    this(0.0, 0.0, 0.0, 0.0);
    // width = 0.0;
    // height = 0.0;
    // x = 0;
    // y = 0;
  }

  public Rectangle(double width, double height, double x, double y) {
    super("Rectangle");
    this.width = width;
    this.height = height;
    this.x = x;
    this.y = y;
  }

  public double translate(double dx, double dy) {
    this.x = dx;
    this.y = dy;
    return x * y;
  }

  @Override
  public double getArea() {
    return width * height;
  }

  public static void main(String[] args) {
    Rectangle r = new Rectangle(10, 20, 30, 40);
    System.out.println("Area of rectangle: " + r.getArea());

    Collection<Shape> rectangles = Arrays.asList(r);
    double totalArea = ShapeUtils.sumAreas(rectangles);
    System.out.println("Total area: " + totalArea);
  }
}

class ShapeUtils {
  public static double sumAreas(Collection<? extends Shape> col) {
    double sum = 0;
    for (Shape s : col) {
      sum += s.getArea();
      System.out.println("Area of shape, " + s.getId() + ": " + s.getArea());
    }
    return sum;
  }
}
