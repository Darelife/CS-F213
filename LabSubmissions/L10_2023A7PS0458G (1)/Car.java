public class Car extends Vehicle {

    public Car(String licensePlate) {
        super(licensePlate, "Compact");
    }

    public String getVehicleType() {
        return "Car";
    }
}
