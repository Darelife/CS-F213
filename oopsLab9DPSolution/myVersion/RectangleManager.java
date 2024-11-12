import java.util.List;

public class RectangleManager {
  public static void analyzeRectangles(List<Rectangle> rectangles) {
    int ans1 = 0;
    for (int i = 1; i < rectangles.size(); i++) {
      Rectangle r = rectangles.get(i);
      Rectangle m = rectangles.get(0);

      double a = Math.min(r.getHeight(), r.getWidth());
      double b = Math.min(m.getHeight(), m.getWidth());
      double c = Math.max(r.getHeight(), r.getWidth());
      double d = Math.max(m.getHeight(), m.getWidth());

      if (a <= b && c <= d) {
        ans1++;
      }
    }
    System.out.println(ans1);

    int ans2 = 0;
    for (int i = 1; i < rectangles.size(); i++) {
      Rectangle r = rectangles.get(i);
      Rectangle m = rectangles.get(0);

      double a = Math.min(r.getHeight(), r.getWidth());
      double b = Math.min(m.getHeight(), m.getWidth());
      double c = Math.max(r.getHeight(), r.getWidth());
      double d = Math.max(m.getHeight(), m.getWidth());

      if ((a >= b && c >= d)) {
        ans2++;
      }
    }
    System.out.println(ans2);

    int ans3 = 1;
    Rectangle o = rectangles.get(0);
    double r1 = o.getHeight() / o.getWidth();
    double r2 = o.getWidth() / o.getHeight();
    double closest = 1e9;
    for (int i = 1; i < rectangles.size(); i++) {
      double rr1 = rectangles.get(i).getHeight() / rectangles.get(i).getWidth();
      double rr2 = rectangles.get(i).getWidth() / rectangles.get(i).getHeight();
      double temp = closest;
      closest = Math.min(closest, Math.min(Math.abs(rr1 - r1), Math.abs(rr2 - r1)));
      closest = Math.min(closest, Math.min(Math.abs(rr1 - r2), Math.abs(rr2 - r2)));
      if (closest != temp)
        ans3 = i;
    }
    System.out.println(ans3);
  }
}
