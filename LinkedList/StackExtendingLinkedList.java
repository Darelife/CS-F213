public class StackExtendingLinkedList extends Link {
  public StackExtendingLinkedList() {
    super(0);
    removeDummyNode();
  }

  private void removeDummyNode() {
    if (start != null) {
      start = start.next;
    }
  }

  public void push(int data) {
    insertAtBeginning(data);
  }

  public int pop() {
    int val = value(0);
    deleteNodeIndex(0);
    return val;
  }

  public int peek() {
    return value(0);
  }

  public boolean isEmpty() {
    return (length() == 0);
  }

  public static void main(String[] args) {
    StackExtendingLinkedList stack = new StackExtendingLinkedList();

    System.out.println("Is stack empty? " + stack.isEmpty());

    stack.push(10);
    stack.push(20);
    stack.push(30);

    System.out.println("Top element: " + stack.peek());

    System.out.println("Popped element: " + stack.pop());
    System.out.println("Popped element: " + stack.pop());

    System.out.println("Is stack empty? " + stack.isEmpty());

    System.out.println("Popped element: " + stack.pop());

    System.out.println("Is stack empty? " + stack.isEmpty());

    try {
      stack.pop(); // This should throw an exception
    } catch (IllegalStateException e) {
      System.out.println("Exception caught: " + e.getMessage());
    }
  }
}