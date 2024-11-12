// Rectangle.java

public class Rectangle extends Figure implements Comparable<Rectangle> {
  private double width;
  private double height;
  private int index; // To identify the rectangle

  // Constructor
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

  // Getters
  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }

  public int getIndex() {
    return index;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  @Override
  public int compareTo(Rectangle o) {
    if (this.getArea() < o.getArea())
      return -1;
    else
      return 1;
  }

  // public boolean fitsIn(Rectangle o) {
  // if (Math.min(this.width, this.height) < Math.min(o.getHeight(), o.getWidth())
  // && Math.max(this.width, this.height) < Math.max(o.getHeight(), o.getWidth()))
  // {
  // return true;
  // }
  // return false;
  // }
}
