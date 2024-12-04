public class HogRider extends Card   // An HogRider "is-a" Card
{
    protected int numAttacks;     // Number of attacks done by the HogRider
    public HogRider(String name, int initialHealth, int[] damage, int x, int y, int radius)   // Constructor
    {
        super(name, initialHealth, damage, x, y, radius);
    }
    public HogRider(String name, int initialHealth, int[] damage, int radius, Point2D centre)   // Overloaded Constructor
    {
        super(name, initialHealth, damage, radius, centre);
    }
    
    public void attack(Card obj)     // Attack another Card
    {
        if (!obj.isDead()) {
            if (this.withinRange(obj)) {
                this.numAttacks++;
                obj.takeDamage(this.getDamage());
                if (numAttacks == 5) {
                    this.incLevel();
                    this.numAttacks = 0;
                }
            } else {
                System.out.println("Out of Range");
            }
        }
    }
}