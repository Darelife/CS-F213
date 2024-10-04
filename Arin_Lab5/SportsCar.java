/**
 * Represents a SportsCar, which is a specific type of Car.
 * This class inherits from the Car class and overrides its abstract methods.
 * Complete the class definition to inherit the car class
 */
public class SportsCar extends Car{  
    public SportsCar(int fuel) {
	    super("SportsCar", 70, 4, fuel);
    }
    @Override
    public void accelerate() {
        if (this.fuel > 0) {
	        this.speed += 20;
        }
    }
    @Override 
    public void brake() {
        if (this.fuel > 0) {
            this.speed -= 5;
        }
    }
}