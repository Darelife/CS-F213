import java.util.*;
// ChargingManager.java
public class ChargingManager {
    private ChargingStation station;
    // TODO: Students need to implement the collection for car owners (use variable name carOwners)
    private Map<String, CarOwner> carOwners = new HashMap<String, CarOwner>();
    
    public ChargingManager(int stationCapacity) {
        this.station = new ChargingStation(stationCapacity);
        // TODO: Initialize the car owners collection
        // this.carOwners = new Map<>();
    }

    // TODO: Implement these methods
    public void processArrival(String name, String make, String model, double batteryCapacity) {
        // Handle new car owner arrival
        Car car = new Car(make,model,batteryCapacity);
        CarOwner carOwner = new CarOwner(name, car);
        carOwners.put(name,carOwner);
        station.handleCarOwnerArrival(carOwner);
    }

    public void processArrival(String name) {
        // Handle existing car owner arrival
        station.handleCarOwnerArrival(carOwners.get(name));
    }

    public void processDeparture(String name) {
        // Handle car owner departure
        station.handleCarOwnerDeparture(carOwners.get(name));
    }

    public void displayAllChargingHistories() {
        for (CarOwner carOwner : carOwners.values()) {
            carOwner.displayChargingHistory();
        }
    }
}

