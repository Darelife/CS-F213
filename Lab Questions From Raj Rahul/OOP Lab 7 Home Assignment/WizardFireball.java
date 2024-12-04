public class WizardFireball extends Fireball    // A Fireball with an Wizard, both can attack separately.
// If the Fireball dies, the Wizard also dies
{
    private Wizard Wizard;  // An WizardFireball "has-a" Wizard

    public WizardFireball(String name, int initialHealth, int[] damage, int x, int y, int radius, Wizard Wizard)   // Constructor
    {
        super(name, initialHealth, damage, x, y, radius);
        this.Wizard = Wizard;
    }
    public WizardFireball(String name, int initialHealth, int[] damage, int radius, Point2D centre, Wizard Wizard)   // Overloaded Constructor
    {
        super(name, initialHealth, damage, radius, centre);
        this.Wizard = Wizard;
    }

    public boolean isWizardDead()   // The Wizard dies if the Fireball dies
    {
        return this.isDead() || this.Wizard.isDead();
    }

    public void WizardAttack(Card obj)     // The Wizard attacks another Card
    {
        if(!this.Wizard.isDead() && this.Wizard.withinRange(obj)) {
            this.Wizard.attack(obj);
        }
    }
    public void attack(Card obj)
    {
        if (obj instanceof WizardFireball) {
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
