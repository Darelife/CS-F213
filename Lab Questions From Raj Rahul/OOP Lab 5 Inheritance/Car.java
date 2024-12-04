public abstract class Car {
    protected String model;
    protected int speed;
    protected int fuelConsumption;
    protected int fuel;
    protected int distanceCovered;

    public Car(String model, int speed, int fuelConsumption, int fuel) {};

    public abstract void accelerate();
    public abstract void brake();

    public void drive(int distance) {};

    //Write Getters and setters
}