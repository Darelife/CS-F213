/**
 * Represents a Sedan, which is a specific type of Car.
 * This class inherits from the Car class and overrides its abstract methods.
 * Complete the class definition to inherit the car class
 */
public class Sedan extends Car {
    public Sedan(int fuel) {
	    super("Sedan", 50, 2, fuel);
    }
    @Override
    public void accelerate() {
        if (this.fuel > 0) {
	        this.speed += 10;
        }
    }
    @Override 
    public void brake() {
        if (this.fuel > 0) {
            this.speed -= 10;
        }
    }
}
