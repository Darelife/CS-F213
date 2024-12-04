// import java.io.*;

// public class One {
//   public static void main(String[] args) {
//     try {
//       FileReader file = new FileReader("input.txt");
//       BufferedReader in = new BufferedReader(file);
//       String line;
//       while ((line = in.readLine()) != null) {
//         System.out.println(line);
//       }
//       in.close();
//       file.close();
//     } catch (FileNotFoundException e) {
//       System.out.println("File Not Found");
//     } catch (IOException e) {
//       System.out.println("IOException: " + e);
//     }
//   }
// }

import java.io.*;

public class One {
  public static void main(String[] args) {
    try {

      FileOutputStream filee = new FileOutputStream("input.txt");
      ObjectOutputStream out = new ObjectOutputStream(filee);
      out.writeObject("Hello, World!");
      out.close();
      filee.close();

      FileInputStream file = new FileInputStream("input.txt");
      ObjectInputStream in = new ObjectInputStream(file);
      String s = (String) in.readObject();
      byte[] obs = s.getBytes("utf-8");
      s = new String(obs, "utf-8");

      System.out.println(s);
      in.close();
      file.close();

      FileInputStream fi = new FileInputStream("input.txt");
      InputStreamReader isr = new InputStreamReader(fi);
      int c;
      while ((c = isr.read()) != -1) {
        System.out.println((char) c);
      }
      isr.close();
      fi.close();

    } catch (FileNotFoundException e) {
      System.out.println("File Not Found");
    } catch (EOFException e) {
      System.out.println("End of File reached");
    } catch (IOException e) {
      System.out.println("IOException: " + e);
    } catch (ClassNotFoundException e) {
      System.out.println("ClassNotFoundException: " + e);
    } catch (Exception e) {
      System.out.println("Exception: " + e);
    }
  }
}