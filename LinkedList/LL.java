import java.util.LinkedList;
import java.util.ListIterator;

// testing the linked list

public class LL {
  public static void main(String[] args) {
    LinkedList<String> staff = new LinkedList<String>();
    staff.addLast("Diana");
    staff.addLast("Harry");
    staff.addLast("Romeo");
    staff.addLast("Tom");

    // | in the comments indicates the iterator position

    ListIterator<String> iterator = staff.listIterator(); // |DHRT
    iterator.next(); // D|HRT
    iterator.next(); // DHR|T

    // Add more elements after second element
    iterator.add("Juliet"); // DHJRT
    iterator.add("Nina"); // DHJNRT
    iterator.add("Nina");

    LinkedList<String> staff2 = new LinkedList<String>();
    LinkedList<Integer> staffCount = new LinkedList<>();
    for (int i = 0; i < staff.size(); i++) {
      boolean found = false;
      int count = 0;
      for (int j = 0; j < i; j++) {
        if (staff.get(i) == staff.get(j)) {
          found = true;
          // count++;
          // break;
        }
      }

      for (int j = 0; j < staff.size(); j++) {
        if (staff.get(i) == staff.get(j)) {
          count++;
        }
      }
      if (!found) {
        staff2.add(staff.get(i));
        staffCount.add(count);
      }
    }

    // Print all elements
    System.out.print("List: ");
    for (String name : staff) {
      System.out.print("\u001B[36m"; + name + " " + "\u001B[0m");
    }
    System.out.println();
    System.out.print("List: ");
    for (String name : staff2) {
      System.out.print("\u001B[34m" + name + " " + "\u001B[0m");
    }
    System.out.println();
    for (Integer count : staffCount) {
      System.out.print("\u001B[31m" + count + " " + "\u001B[0m");
    }

    // iterator.next(); // DHJN|RT

    // // Remove last traversed element
    // iterator.remove(); // DHJN|T

    // // Print all elements
    // System.out.print("List: ");
    // for (String name : staff) {
    // System.out.print(name + " ");
    // }
    // System.out.println();

    // System.out.println("Expected: Diana Harry Juliet Nina Tom");

    // // Remove all elements that come after the last traversed element
    // while (iterator.hasNext()) {
    // iterator.next();
    // iterator.remove();
    // }

    // // Print all elements
    // System.out.print("List: ");
    // for (String name : staff) {
    // System.out.print(name + " ");
    // }
    // System.out.println();
    // }
  }
}

public static String getColoredString(String text, String color) {
  String colorCode;
  switch (color.toUpperCase()) {
    case "RED":
      colorCode = "\u001B[31m";
      break;
    case "GREEN":
      colorCode = "\u001B[32m";
      break;
    case "YELLOW":
      colorCode = "\u001B[33m";
      break;
    case "BLUE":
      colorCode = "\u001B[34m";
      break;
    case "PURPLE":
      colorCode = "\u001B[35m";
      break;
    case "CYAN":
      colorCode = "\u001B[36m";
      break;
    default:
      colorCode = "\u001B[0m"; // Reset
  }
  return colorCode + text + "\u001B[0m"; // Reset color after text
}