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
//     ■ Both the Wizard and the Fireball attack separately.
// The Wizard behaves like a normal Wizard.
// ■ Use the WizardAttack method to attack other
// objects using the Wizard.
// ■ The number of attacks and the level of the Fireball
// and the Wizard are separate.

// ■ isWizardDead(): Should return true if the Wizard is
// dead. The Wizard may die as a normal Wizard dies or
// when the Fireball dies. However, while the Fireball
// can live when the Wizard is dead, the Wizard cannot
// live without the Fireball.
// ■ Complete the attack(Card obj) method for the
// WizardFireball:
// ■ The WizardFireball can attack any object except
// another WizardFireball. If it attempts to do so,
// print "Attack Failed".
// ■ If the object is out of range, print "Out of Range".
// ■ Only one message should be printed for each
// attack attempt, starting with the "Attack Failed"
// condition.■ The Fireball's level should increase after every 4
// successful attacks, while the Wizard's level
// increases according to its own rules.


    public boolean isWizardDead()   // The Wizard dies if the Fireball dies
    {
        if(this.Wizard.isDead() || this.isDead()){
            return true;
        }
        return false;

    }
    public void WizardAttack(Card obj)     // The Wizard attacks another Card
    {
        if(obj instanceof WizardFireball){
            System.out.println("Attack failed");
        }
        else if(this.withinRange(obj)){
            this.Wizard.attack(obj);
            this.attack(obj);
            // if(obj instanceof Fireball){
            //     // Do nothing if the instance is Fireball
            // }
            // else{
            //     obj.takeDamage(this.getDamage());
            //     this.numAttacks++;
            // }
        }
        else{
            System.out.println("Out of Range");
        }
    }
}
