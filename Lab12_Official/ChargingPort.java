public class ChargingPort {
    private int portNumber;
    private CarOwner currentUser;

    public ChargingPort(int portNumber) {
        this.portNumber = portNumber;
    }

    public boolean isOccupied() {
        return currentUser != null;
    }

    public boolean isOccupiedBy(CarOwner carOwner) {
        return currentUser == carOwner;
    }

    public void startCharging(CarOwner carOwner) {
        currentUser = carOwner;
    }

    public CarOwner stopCharging() {
        CarOwner departingOwner = currentUser;
        if (currentUser != null) {
            ChargingSession session = new ChargingSession(currentUser.getCar().getBatteryCapacity());
            currentUser.addChargingSession(session);
            currentUser = null;
        }
        return departingOwner;
    }

    public int getPortNumber() {
        return portNumber;
    }
}