public class Rectangle extends Figure implements Comparable<Rectangle> {
  private double width, height;
  private int index;

  public Rectangle(double width, double height, int index) {
    this.width = width;
    this.height = height;
    this.index = index;
  }

  public double getArea() {
    return this.width * this.height;
  }

  public double getPerimeter() {
    return 2 * (this.width + this.height);
  }

  public double getWidth() {
    return this.width;
  }

  public double getHeight() {
    return this.height;
  }

  public int getIndex() {
    return this.index;
  }

  public int compareTo(Rectangle o) {
    if (this.getArea() < o.getArea())
      return -1;
    else
      return 1;
  }
}
