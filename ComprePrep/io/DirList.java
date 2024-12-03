import java.io.*;
// import java.util.*;

public class DirList {
  public static void main(String[] args) {
    File path = new File("../slides");
    String[] list;
    System.out.println(path.getAbsolutePath());
    list = path.list();
    for (int i = 0; i < list.length; i++)
      System.out.println(list[i]);
  }
}