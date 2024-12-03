import java.io.*;

public class Io {
  public static void main(String[] args) throws IOException {
    // InputStreamReader isr = new InputStreamReader(System.in);
    // int c;
    // try {
    // // Read characters from the input stream until the end of the stream is
    // reached
    // while ((c = isr.read()) != -1) {
    // System.out.println(c);
    // }
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // String s;
    // try {
    // while ((s = br.readLine()) != null) {
    // System.out.println(s);
    // }
    // } catch (IOException e) {
    // e.printStackTrace();
    // }

    FileInputStream in = new FileInputStream(args[0]);
    int cnt = 0;
    while (true) {
      int a = in.read();
      if (a == -1) {
        break;
      }
      cnt++;
      System.out.println((char) a + " " + a);
    }
    in.close();
    System.out.println(cnt);

    byte from = (byte) args[0].charAt(0);
    byte to = (byte) args[1].charAt(0);
    int x;
    while ((x = System.in.read()) != -1) {
      System.out.write(x == from ? to : x);
    }
  }

}
