class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

public class Link {
  protected Node start;

  public Link(int data) {
    this.start = new Node(data);
  }

  public void insertAtBeginning(int data) {
    Node newNode = new Node(data);
    newNode.next = start;
    start = newNode;
  }

  public void insertAtEnd(int data) {
    Node newNode = new Node(data);
    Node lastNode = start;
    if (start.next == null) {
      start = newNode;
      return;
    }
    while (lastNode.next != null) {
      lastNode = lastNode.next;
    }
    lastNode.next = newNode;
  }

  public void deleteNodeIndex(int index) {
    if (start == null) {
      throw new IndexOutOfBoundsException("List is empty");
    }
    if (index == 0) {
      start = start.next;
      return;
    }
    Node current = start;
    Node previous = null;
    int currentIndex = 0;
    while (current != null && currentIndex < index) {
      previous = current;
      current = current.next;
      currentIndex++;
    }
    if (current == null) {
      throw new IndexOutOfBoundsException("Index out of range");
    }
    previous.next = current.next;
  }

  public void insertInBetween(int index, int data) {
    int ind = 0;
    if (index == 0) {
      Node neww = new Node(data);
      neww.next = start;
      start = neww;
      return;
    }
    Node curNode = start;
    Node prevNode = start;
    while (ind != index) {
      prevNode = curNode;
      curNode = curNode.next;
      ind++;
    }
    if (prevNode == null) {
      throw new IndexOutOfBoundsException("Index out of range");
    }
    Node neww = new Node(data);
    prevNode.next = neww;
    neww.next = curNode;
  }

  public int value(int index) {
    if (start == null) {
      throw new IndexOutOfBoundsException("List is empty");
    }
    Node current = start;
    int currentIndex = 0;
    while (current != null && currentIndex < index) {
      current = current.next;
      currentIndex++;
    }
    if (current == null) {
      throw new IndexOutOfBoundsException("Index out of range");
    }
    return current.data;
  }

  public int length() {
    int count = 0;
    Node current = start;
    while (current != null) {
      count++;
      current = current.next;
    }
    return count;
  }

}

class Stack {
  private Node top;

  public Stack() {
    this.top = null;
  }

  public void push(int data) {
    Node neww = new Node(data);
    neww.next = top;
    top = neww;
  }

  public int pop() {
    if (top == null) {
      throw new IllegalStateException("Stack is empty");
    }
    int data = top.data;
    top = top.next;
    return data;
  }

  public int peek() {
    int data = top.data;
    return data;
  }

  public boolean isEmpty() {
    return (top == null);
  }

  public static void main(String[] args) {
    Stack stack = new Stack();
    stack.push(10);
    stack.push(20);
    stack.push(30);

    System.out.println(stack.peek()); // 30
    System.out.println(stack.pop()); // 30
    System.out.println(stack.pop()); // 20
    System.out.println(stack.isEmpty()); // false
    System.out.println(stack.pop()); // 10
    System.out.println(stack.isEmpty()); // true
  }
}

class Queue {

}