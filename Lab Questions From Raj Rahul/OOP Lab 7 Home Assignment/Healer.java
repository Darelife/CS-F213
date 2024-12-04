public class Healer extends Card      // For a healer, the damage array will have negative values
{
    private int numHeals;     // Number of heals done by the healer
    public Healer(String name, int initialHealth, int[] damage, int x, int y, int radius)   // Constructor
    {
        super(name, initialHealth, damage, x, y, radius);
    }
    public Healer(String name, int initialHealth, int[] damage, int radius, Point2D centre)   // Overloaded Constructor
    {
        super(name, initialHealth, damage, radius, centre);
    }
    public void heal(Card obj)     // A healer should heal only an Wizard(Keep in mind that an IceWizard is also an Wizard)
    {
        if (!(obj instanceof Healer) && !(obj instanceof Fireball) && (obj instanceof Wizard)){
            if(!obj.isDead()){
                if (this.withinRange(obj)){
                    obj.takeDamage(this.getDamage());
                    this.numHeals++;
                    if(numHeals == 3){
                        this.incLevel();
                        numHeals = 0;
                    }
                } else {
                    System.out.println("Out Of Range");
                }
            }
        } else {
            System.out.println("Heal Failed");
        }
    }
}
