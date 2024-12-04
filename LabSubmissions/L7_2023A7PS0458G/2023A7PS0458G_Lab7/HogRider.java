public class HogRider extends Card // An HogRider "is-a" Card
{
    protected int numAttacks; // Number of attacks done by the HogRider

    public HogRider(String name, int initialHealth, int[] damage, int x, int y, int radius) // Constructor
    {
        super(name, initialHealth, damage, x, y, radius);
        this.numAttacks = 0;
    }

    public HogRider(String name, int initialHealth, int[] damage, int radius, Point2D centre) // Overloaded Constructor
    {
        super(name, initialHealth, damage, radius, centre);
        this.numAttacks = 0;
    }

    // ■ The HogRider can attack any object within its range.
    // ■ The HogRider's level should increase after every 5
    // successful attacks.
    // ■ Print "Out of Range" if an object is not within range.

    public void attack(Card obj) // Attack another Card
    {
        if (this.withinRange(obj)) {
            obj.takeDamage(this.getDamage());
            if (++this.numAttacks % 5 == 0) {
                this.incLevel();
            }
        } else {
            System.out.println("Out of Range");
        }
    }
}