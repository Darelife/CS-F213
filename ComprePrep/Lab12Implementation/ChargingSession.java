public class ChargingSession {
  private double energyCharged; // in kWh

  public ChargingSession(double batteryCapacity) {
    this.energyCharged = calculateEnergyCharged(batteryCapacity);
  }

  private double calculateEnergyCharged(double batteryCapacity) {
    // Simplistic calculation: assume charging to 80% of battery capacity
    return 0.8 * batteryCapacity;
  }

  @Override
  public String toString() {
    return String.format("Charging session: Energy charged: %.2f kWh", energyCharged);
  }
}