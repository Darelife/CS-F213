public abstract class ParkingSpot implements Parkable {

    protected Vehicle currentVehicle;

    public ParkingSpot() {
        currentVehicle = null;
    }

    public abstract String getSize();

    public void leave() {
        System.out.println("Vehicle left from " + getSize() + " spot.");
        currentVehicle = null;
    }

}

