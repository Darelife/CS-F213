public abstract class Car {
    protected String model;
    protected int speed;
    protected int fuelConsumption;
    protected int fuel;
    protected double distanceCovered;

    public Car(String model, int speed, int fuelConsumption, int fuel) {
        this.model = model;
        this.speed = speed;
        this.fuelConsumption = fuelConsumption;
        this.fuel = fuel;
        this.distanceCovered = 0;
    };

    public abstract void accelerate();
    public abstract void brake();

    public void drive(int distance) {
        
        int fuelRequired = distance * fuelConsumption;
        int fuelUsed;
        if (fuelRequired > this.fuel) {
            fuelUsed = this.fuel;
        } else {
            fuelUsed = fuelRequired;
        }
        this.fuel -= fuelUsed;
        this.distanceCovered += fuelUsed * 1.0 / fuelConsumption;
    };

    //Write Getters and setters
    public void setModel(String model) {
        this.model = model;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
    public void setFuel (int fuel) {
        this.fuel = fuel;
    }
    public void setDistanceCovered (int distanceCovered) {
        this.distanceCovered = distanceCovered;
    }
    // getters
    public String getModel() {
        return model;
    }
    public int getSpeed() {
        return speed;
    }
    public int getFuelConsumption() {
        return fuelConsumption;
    }
    public int getFuel () {
        return fuel;
    }
    public int getDistanceCovered () {
        return (int) distanceCovered;
    }
    @Override 
    public String toString() {
        return "{ " + 
            "speed: " + this.speed + ", " +
            "fuel: " + this.fuel + ", " +
            "distanceCovered: " + this.distanceCovered +
        " }";
    }
}
