public abstract class Shape {
  private String id;
  final int PK = 1;

  public Shape(String id) {
    this.id = id;
  }

  public abstract double getArea();

  public String getId() {
    return id;
  }

  public String toString() {
    return "Shape[id= " + id + ", Area = " + getArea() + "]";
  }
}
