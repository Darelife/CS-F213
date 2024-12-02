import java.util.*;

public class QueueImpl {
  // public LinkedList<Integer> lltest = new LinkedList<Integer>();
  public static Queue<Integer> qt = new LinkedList<Integer>();
  public static Stack<Integer> st = new Stack<Integer>();
  // priority queue
  public static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
  public static List<Integer> li = new ArrayList<Integer>();

  public static void main(String[] args) {
    qt.add(1);
    qt.add(2);
    qt.add(3);

    System.out.println(qt);
    qt.poll();
    System.out.println(qt);

    qt.add(4);
    System.out.println(qt);

    System.out.println(qt.peek());

    st.push(1);
    st.push(2);
    st.push(3);

    System.out.println(st);
    st.pop();
    System.out.println(st);

    st.push(4);
    System.out.println(st);

    System.out.println(st.peek());

    pq.add(4);
    pq.add(3);
    pq.add(2);

    System.out.println(pq);

    System.out.println(pq.poll());
    System.out.println(pq);

    System.out.println(pq.peek());

    pq.add(4);
    System.out.println(pq);

    System.out.println(pq.poll());

    li.add(1);
    li.add(2);
    li.add(3);
    System.out.println(li);
  }
}
