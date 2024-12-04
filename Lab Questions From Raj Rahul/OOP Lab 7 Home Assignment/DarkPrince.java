public class DarkPrince extends Prince     // An DarkPrince "is-a" Prince
{
    public DarkPrince(String name, int initialHealth, int[] damage, int x, int y, int radius)  // Constructor
    {
        super(name, initialHealth, damage, x, y, radius);
    }
    public DarkPrince(String name, int initialHealth, int[] damage, int radius, Point2D centre)   // Overloaded Constructor
    {
        super(name, initialHealth, damage, radius, centre);
    }

    public void attack(Card obj)     // Override the inherited method
    {
        if (!obj.isDead()) {
            if (this.withinRange(obj)) {
                this.numAttacks++;
                obj.takeDamage(2 * this.getDamage());
                if (numAttacks == 2) {
                    this.incLevel();
                    this.numAttacks = 0;
                }
            } else {
                System.out.println("Out of Range");
            }
        }
    }
}
