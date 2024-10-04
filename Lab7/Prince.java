public class Prince extends Card // An Prince "is-a" Card
{
    protected int numAttacks; // Number of attacks done by the Prince

    public Prince(String name, int initialHealth, int[] damage, int x, int y, int radius) // Constructor
    {
        super(name, initialHealth, damage, x, y, radius);
        this.numAttacks = 0;
    }

    public Prince(String name, int initialHealth, int[] damage, int radius, Point2D centre) // Overloaded Constructor
    {
        super(name, initialHealth, damage, radius, centre);
        this.numAttacks = 0;
    }
    // ■ The Prince can attack any object within its range.
    // ■ The Prince's level should increase after every 2
    // successful attacks.
    // ■ Print "Out of Range" if an object is not within range.

    public void attack(Card obj) // Attack another Card
    {
        if (this.withinRange(obj)) {
            obj.takeDamage(this.getDamage());
            if (++this.numAttacks % 2 == 0) {
                this.incLevel();
            }
        } else {
            System.out.println("Out of Range");
        }
    }
}