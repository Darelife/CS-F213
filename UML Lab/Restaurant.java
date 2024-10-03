import java.util.ArrayList;
import java.util.Queue;

class Restaurant {
  private ArrayList<Order> tables;
  private ArrayList<Staff> staffMembers;
  public FoodMenu foodMenu;
  public FoodMenu kidsMenu;
  public BeverageMenu beverageMenu;
  public BeverageMenu cocktailMenu;
  public Queue<MenuItem> foodQueue;
  public Queue<MenuItem> beverageQueue;

  public Restaurant(int restaurant) {
    return;
  }

  public void addStaff(Staff staff) {
    return;
  }

  private void addOrder(Order order) {
    return;
  }

  public boolean assignTable(Order order) {
    return false;
  }

  public MenuItem startPreparingFood(int food) {
    return null;
  }

  public MenuItem startPreparingBeverage(int beverage) {
    return null;
  }

  public int freeTable(Order order) {
    return 0;
  }
}