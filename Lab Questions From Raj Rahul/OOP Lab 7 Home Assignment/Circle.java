public class Circle extends Shape   // A Circle "is-a" Shape
{
    // Each Circle "has-a" Point2D, inherited from its parent
    private int radius;

    public Circle(int x, int y, int radius)  // Constructor
    {
        super(x, y);
        this.radius = radius;
    }
    public Circle(Point2D centre, int radius)   // Overloaded Constructor
    {
        this(centre.getX(), centre.getY(), radius);
    }

    // Methods
    public int getRadius()  // Return the radius of the Circle
    {
        return this.radius;
    }
    public double getArea()     // Override the inherited method, Return the Area of the Circle
    {
        return Math.PI * Math.pow(radius, 2);
    }
    public double getPerimeter()    // Override the inherited method, Return the Perimeter of the Circle
    {
        return 2 * Math.PI * this.radius;
    }
    public boolean withinCircle(Point2D point)  // Return true if the point lies within the Circle
    {
        double distance = Math.sqrt(Math.pow(this.getCentre().getX() - point.getX(), 2) + Math.pow(this.getCentre().getY() - point.getY(), 2));
        return distance <= this.getRadius();
    }
}