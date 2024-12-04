import java.util.*;

public class QueueImpl {
  // public LinkedList<Integer> lltest = new LinkedList<Integer>();
  public static Queue<Integer> qt = new LinkedList<Integer>(Arrays.asList(1, 2, 3));
  public static Stack<Integer> st = new Stack<Integer>();
  public static LinkedList<Integer> ll = new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
  public static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
  public static List<Integer> li = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
  public static Map<Integer, Integer> mp = new HashMap<>();

  public static void main(String[] args) {

    qt.poll();
    qt.add(4);
    // System.out.println(qt.peek());

    st.addAll(Arrays.asList(1, 2, 3));
    st.pop();
    st.push(4);
    // System.out.println(st.peek());

    pq.addAll(Arrays.asList(4, 3, 2, 19, 28, 4, 3, 2, 19));
    // pq doesn't sort the array, but it keeps the smallest element in the front
    pq.poll();
    pq.poll();
    // System.out.println(pq.peek());
    pq.add(4);

    // System.out.println(li);
    li.add(4);

    // ll.add(4);
    ListIterator<Integer> i = ll.listIterator();
    int index = 0;
    for (; i.hasNext(); index++) {
      int a = i.next();
      if (a == 4) {
        i.previous();
        break;
      }
      System.out.println(a + " " + (index));
    }
    index--;
    // now basically 'i' is at the end of the list, last element..
    // 1 2 3 4 5 6(i points to 6)
    // i.hasPrevious() is true
    // i.previous() will give 6..Why? Why not 5?
    while (i.hasPrevious()) {
      System.out.println(i.previous() + " " + (index--));
    }

    mp.put(2, 2);
    mp.put(1, 1);

    // iterate through the map
    for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
      System.out.println(entry.getKey() + " " + entry.getValue());
    }
  }
}

class Abc {
  public <E extends Comparable<E>> E min(E o1, E o2) {
    if (o1.compareTo(o2) < 0) {
      return o1;
    } else {
      return o2;
    }
  }
}