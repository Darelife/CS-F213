public class Fireball extends Card {
    protected int numAttacks; // Number of attacks done by the Fireball

    public Fireball(String name, int initialHealth, int[] damage, int x, int y, int radius) // Constructor
    {
        super(name, initialHealth, damage, x, y, radius);
        this.numAttacks = 0;
    }

    public Fireball(String name, int initialHealth, int[] damage, int radius, Point2D centre) // Overloaded Constructor
    {
        super(name, initialHealth, damage, radius, centre);
        this.numAttacks = 0;
    }

    // ■ The Fireball can attack any object except another
    // Fireball. If it attempts to do so, print "Attack Failed".
    // ■ If the object is out of range, print "Out of Range".
    // ■ Only one message should be printed for each attack
    // attempt, starting with the "Attack Failed" condition.
    // ■ The Fireball's level should increase after every 4
    // successful attacks.
    public void attack(Card obj) // Attack another Card, should not attack other Fireballs.
    {
        if (obj instanceof Fireball) {
            System.out.println("Attack Failed");
        } else if (this.withinRange(obj)) {
            obj.takeDamage(this.getDamage());
            if ((++this.numAttacks) % 4 == 0) {
                this.incLevel();
            }
        } else {
            System.out.println("Out of Range");
        }

    }
}
