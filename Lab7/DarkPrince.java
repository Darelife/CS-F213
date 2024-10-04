public class DarkPrince extends Prince // An DarkPrince "is-a" Prince
{
    public DarkPrince(String name, int initialHealth, int[] damage, int x, int y, int radius) // Constructor
    {
        super(name, initialHealth, damage, x, y, radius);
    }

    public DarkPrince(String name, int initialHealth, int[] damage, int radius, Point2D centre) // Overloaded
                                                                                                // Constructor
    {
        super(name, initialHealth, damage, radius, centre);
    }

    // ○ A special type of Prince that deals twice the damage per
    // attack as a normal Prince.
    // ○ All other attributes and behaviors are the same as the
    // standard Prince.

    public void attack(Card obj) // Override the inherited method
    {
        if (this.withinRange(obj)) {
            obj.takeDamage(this.getDamage() * 2);
            if ((++this.numAttacks) % 2 == 0) {
                this.incLevel();
            }
        } else {
            System.out.println("Out of Range");
        }
    }
}
