public class Fireball extends Card
{
    protected int numAttacks;     // Number of attacks done by the Fireball
    public Fireball(String name, int initialHealth, int[] damage, int x, int y, int radius)   // Constructor
    {
        super(name, initialHealth, damage, x, y, radius);
    }
    public Fireball(String name, int initialHealth, int[] damage, int radius, Point2D centre)   // Overloaded Constructor
    {
        super(name, initialHealth, damage, radius, centre);
    }

    public void attack(Card obj)     // Attack another Card, should not attack other Fireballs.
    {
        if (obj instanceof Fireball) {
            System.out.println("Attack Failed");
        } else if (!obj.isDead()) {
            if (this.withinRange(obj)) {
                this.numAttacks++;
                obj.takeDamage(this.getDamage());
                if (numAttacks == 4) {
                    this.incLevel();
                    this.numAttacks = 0;
                }
            } else {
                System.out.println("Out of Range");
            }
        }
    }
}
