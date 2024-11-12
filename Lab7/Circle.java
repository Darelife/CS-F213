
//include math library
import java.lang.Math;

public class Circle extends Shape // A Circle "is-a" Shape
{
    // Each Circle "has-a" Point2D, inherited from its parent
    private int radius;

    public Circle(int x, int y, int radius) // Constructor
    {
        super(x, y);
        this.radius = radius;
    }

    public Circle(Point2D centre, int radius) // Overloaded Constructor
    {
        super(centre);
        this.radius = radius;
    }

    // Methods
    public int getRadius() // Return the radius of the Circle
    {
        return this.radius;
    }

    public double getArea() // Override the inherited method, Return the Area of the Circle
    {
        double area = Math.pow(this.radius, 2);
        area *= Math.PI;
        return area;
    }

    public double getPerimeter() // Override the inherited method, Return the Perimeter of the Circle
    {
        double perimeter = 2 * Math.PI * this.radius;
        return perimeter;
    }

    public boolean withinCircle(Point2D point) // Return true if the point lies within the Circle
    {
        double distance = Math.pow((point.getX() - this.getCentre().getX()), 2);
        distance += Math.pow(point.getY() - this.getCentre().getY(), 2);
        distance = Math.sqrt(distance);

        if (distance <= this.radius)
            return true;
        else
            return false;
    }
}