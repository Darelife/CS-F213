import java.util.*;

// ChargingStation.java
public class ChargingStation {
  // TODO: Students need to implement collections for charging ports and waiting
  // queue (use variable names chargingPorts and waitingQueue)
  private LinkedList<ChargingPort> chargingPorts;
  private int portCount;
  private Queue<CarOwner> waitingQueue;

  public ChargingStation(int numberOfPorts) {
    // TODO: Initialize the charging ports and waiting queue collections . (HINT :
    // You might need to use a loop to initialise the charging ports)
    this.portCount = numberOfPorts;
    this.chargingPorts = new LinkedList<ChargingPort>();
    for (int i = 0; i < numberOfPorts; i++) {
      this.chargingPorts.addLast(new ChargingPort(i));
    }
    this.waitingQueue = new LinkedList<CarOwner>();
  }

  // TODO: Implement these methods
  public void handleCarOwnerArrival(CarOwner carOwner) {
    // Handle car owner arrival logic

    ListIterator<ChargingPort> li = chargingPorts.listIterator();
    boolean found = false;
    while (li.hasNext()) {
      ChargingPort cp = li.next();
      if (!cp.isOccupied()) {
        System.out.println(carOwner.getName() + " started charging at port " + cp.getPortNumber());
        found = true;
        cp.startCharging(carOwner);
        break;
      }
    }
    if (!found) {
      waitingQueue.add(carOwner);
      System.out.println("All ports are occupied. Adding " + carOwner.getName() + " to the waiting queue.");
    }
  }

  public void handleCarOwnerDeparture(CarOwner carOwner) {
    // Handle car owner departure logic
    ListIterator<ChargingPort> li = chargingPorts.listIterator();
    boolean found = false;
    int port = 0;
    while (li.hasNext()) {
      ChargingPort cp = li.next();
      if (cp.isOccupiedBy(carOwner)) {
        cp.stopCharging();
        found = true;
        System.out.println(carOwner.getName() + " finished charging and left.");
        port = cp.getPortNumber();
        break;
      }
    }
    checkWaitingQueue();

  }

  private void checkWaitingQueue() {
    // Check and process waiting queue
    ListIterator<ChargingPort> li = chargingPorts.listIterator();
    while (li.hasNext()) {
      ChargingPort cp = li.next();
      if (!cp.isOccupied()) {
        if (!waitingQueue.isEmpty()) {
          CarOwner co = waitingQueue.poll();
          System.out.println(co.getName() + " started charging at port " + cp.getPortNumber());
          cp.startCharging(co);
        }
      }
    }
  }
}
