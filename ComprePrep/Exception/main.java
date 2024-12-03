import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

class NoSuchAttributeException extends Exception {

  public NoSuchAttributeException(String name) {
    super("No attribute named \"" + name + "\" found");
  }
}

public class main {
  // claiming that this method throws an exception
  public static void calculate() throws ArithmeticException {
    int a = 10;
    int b = 0;
    int c = a / b;
    System.out.println(c);
  }

  public static void readFile() throws FileNotFoundException {
    File file = new File("nonexistentfile.txt");
    FileInputStream fileInputStream = new FileInputStream(file);
  }

  public static void checkAttribute(String attributeName) throws NoSuchAttributeException {
    // Simulate checking for an attribute
    // boolean attributeExists = false; // Assume the attribute does not exist

    // if (!attributeExists) {
    throw new NoSuchAttributeException(attributeName);
    // }

    // If the attribute exists, continue with the rest of the method
    // System.out.println("Attribute found.");
  }

  public static void main(String[] args) {
    try {
      int a = 10;
      int b = 0;
      int c = a / b;
      System.out.println(c);
    } catch (ArithmeticException e) {
      System.out.println("Arithmetic Exception");
    } catch (Exception e) {
      System.out.println("Exception");
    }
    System.out.println("Rest of the code");

    try {
      calculate();
    } catch (ArithmeticException e) {
      System.out.println("Arithmetic Exception");
    } catch (Exception e) {
      System.out.println("Exception");
    }

    try {
      readFile();
    } catch (FileNotFoundException e) {
      System.out.println("File not found");
    }
    System.out.println("Rest of the code");

    try {
      checkAttribute("abc");
    } catch (NoSuchAttributeException e) {
      System.out.println(e.getMessage());
    }
  }
}
