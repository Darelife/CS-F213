public interface Parkable {
    boolean canPark(Vehicle vehicle);
    void park(Vehicle vehicle);
    void leave();
}

