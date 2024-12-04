public class Car {
  private String make;
  private String model;
  private double batteryCapacity; // in kWh

  public Car(String make, String model, double batteryCapacity) {
    this.make = make;
    this.model = model;
    this.batteryCapacity = batteryCapacity;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public double getBatteryCapacity() {
    return batteryCapacity;
  }

  @Override
  public String toString() {
    return make + " " + model;
  }
}