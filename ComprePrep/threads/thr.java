// package threads;

class Output extends Thread {
  private String message;

  public Output(String message) {
    this.message = message;
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(message);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class thr {
  public static void main(String[] args) {
    Output a = new Output("Hello");
    // sleep for 10 ms
    a.start();
    try {
      Thread.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Output b = new Output("World!");
    b.start();
  }
}
