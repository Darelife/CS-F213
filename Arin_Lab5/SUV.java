
/**
 * Represents a SUV, which is a specific type of Car.
 * This class inherits from the Car class and overrides its abstract methods.
 * Complete the class definition to inherit the car class
 */
/**
 */
public class SUV extends Car {
    public SUV(int fuel) {
	    super("SUV", 40, 3, fuel);
    }
    @Override
    public void accelerate() {
	    if (this.fuel > 0) {
            this.speed += 5;
        }
    }
    @Override 
    public void brake() {
        if (this.fuel > 0) {
            this.speed -= 15;
        }
    }
}