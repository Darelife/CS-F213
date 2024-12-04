import java.util.*;

public class CarOwner {
  private String name;
  private Car car;
  // TODO: Students need to implement the collection for charging history (use
  // variable name chargingHistory)
  private LinkedList<String> chargingHistory;

  public CarOwner(String name, Car car) {
    this.name = name;
    this.car = car;
    // TODO: Initialize the charging history collection
    chargingHistory = new LinkedList<String>();
  }

  public String getName() {
    return name;
  }

  public Car getCar() {
    return car;
  }

  // TODO: Implement this method
  public void addChargingSession(ChargingSession session) {
    // Add the charging session to charging history
    chargingHistory.addLast(session.toString());
  }

  public void displayChargingHistory() {
    System.out.println(name + "'s charging history:");
    for (String session : chargingHistory) {
      System.out.println(session);
    }
  }

}
