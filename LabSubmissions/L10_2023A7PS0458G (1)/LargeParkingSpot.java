public class LargeParkingSpot extends ParkingSpot {
    public boolean canPark(Vehicle vehicle) {
        if (vehicle.getSize() == "Large" | vehicle.getSize() == "Compact") {
            if (currentVehicle==null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public void park(Vehicle vehicle) {
        if (canPark(vehicle)) {
            System.out.println(vehicle.getVehicleType() + " parked in large spot.");
            currentVehicle = vehicle;
        }
        else System.out.println("Cannot park " + vehicle.getVehicleType() + " in Large spot.");
    }

    public String getSize() {
        return "Large";
    }

}
