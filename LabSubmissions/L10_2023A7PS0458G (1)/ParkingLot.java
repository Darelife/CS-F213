public class ParkingLot {
    private ParkingSpot[] parkingSpots;

    public ParkingLot(int numCompact, int numLarge) {
        parkingSpots = new ParkingSpot[numCompact + numLarge];
        for (int i = 0; i < numCompact; i++) {
            parkingSpots[i] = new CompactParkingSpot();
        }
        for (int i = numCompact; i < numCompact + numLarge; i++) {
            parkingSpots[i] = new LargeParkingSpot();
        }
    }

    public void parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : parkingSpots) {
            if (spot.canPark(vehicle)) {
                spot.park(vehicle);
                return;
            }
        }
        System.out.println("No available spots for " + vehicle.getVehicleType());
    }
}

