public class CompactParkingSpot extends ParkingSpot {
    public boolean canPark(Vehicle vehicle) {
        if (vehicle.getSize() == "Compact") {
            // System.out.println(currentVehicle);
            // if (currentVehicle instanceOf Vehicle) {
            if (currentVehicle == null) {
                return true;
            }
            // System.out.println("works");
            return false;
        }
        return false;
    }

    public void park(Vehicle vehicle) {
        if (canPark(vehicle)) {
            System.out.println(vehicle.getVehicleType() + " parked in compact spot.");
            currentVehicle = vehicle;
        }
        else System.out.println("Cannot park " + vehicle.getVehicleType() + " in compact spot.");
    }

    public String getSize() {
        return "Compact";
    }
}
