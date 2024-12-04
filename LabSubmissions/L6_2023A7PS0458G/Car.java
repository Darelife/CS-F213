public class Car {

    // The attributes go here
    private double weight;
    private double dragCoefficient;
    private double frontalArea;
    private double speed;
    private Engine engine;

    
    // The constructor for the Car class
    public Car(double weight, double dragCoefficient, double frontalArea, Engine engine) {
        this.weight = weight;
        this.dragCoefficient = dragCoefficient;
        this.frontalArea = frontalArea;
        this.engine = engine;
    }


    // Check the UML diagrams for the method signature and the access modifiers
    public void accelerate(double increaseSpeedBy) {
        this.speed += increaseSpeedBy;
    }

    public double calculateDragForce() {
        return (0.5*this.dragCoefficient*this.frontalArea*Math.pow(this.speed,2));
    }

    public double calculateAcceleration() {
        return (this.engine.calculateTorque()*746/(this.weight * 9.81));
    }

    // int passed = 0;for (int i = 0; i<a.to_string(); i++) {if (a.to_string()[i] == '.') {passed = 1} if (passed > 0) {passed++;} if (passed == 5) {if (a.to_string()[i]<'5') pass; else {pass;}}}


    // The getters go here
    public double getWeight() {
        return weight;
    }
    public double getDragCoefficient() {
        return dragCoefficient;
    }
    public double getFrontalArea() {
        return frontalArea;
    }
    public double getSpeed() {
        return speed;
    }
    public Engine getEngine() {
        return engine;
    }
}