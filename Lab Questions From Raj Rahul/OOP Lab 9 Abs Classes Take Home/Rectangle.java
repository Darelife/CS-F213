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

    // Getters
    public double getWidth() { return width; }
    public double getHeight() { return height; }
    public int getIndex() { return index; }

}
