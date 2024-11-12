public // Node class for Linked List
class Node {
  int data;
  Node next;

  // Constructor to initialize a node
  public Node(int data) {
    this.data = data;
    this.next = null;
  }
}

// LinkedList class
public class LinkedListMaamsVersion {
  private Node head;

  // Constructor to initialize the linked list
  public LinkedList() {
        this.head = null;
    }

  // Method to insert a new node at the end
  public void insert(int data) {
    Node newNode = new Node(data);

    if (head == null) {
      head = newNode;
    } else {
      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
    }
  }

  // Method to display the linked list
  public void display() {
    if (head == null) {
      System.out.println("The list is empty.");
      return;
    }

    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  // Method to delete a node by value
  public void delete(int value) {
    if (head == null) {
      System.out.println("List is empty, nothing to delete.");
      return;
    }

    // If the head node itself holds the value to be deleted
    if (head.data == value) {
      head = head.next;
      return;
    }

    Node temp = head;
    while (temp.next != null && temp.next.data != value) {
      temp = temp.next;
    }

    if (temp.next == null) {
      System.out.println("Value not found in the list.");
    } else {
      temp.next = temp.next.next;
    }
  }

  // Method to find the length of the linked list
  public int length() {
    int count = 0;
    Node temp = head;
    while (temp != null) {
      count++;
      temp = temp.next;
    }
    return count;
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();

    // Inserting elements
    list.insert(10);
    list.insert(20);
    list.insert(30);

    // Displaying the list
    System.out.print("Linked List: ");
    list.display();

    // Deleting an element
    list.delete(20);
    System.out.print("After deleting 20: ");
    list.display();

    // Length of the list
    System.out.println("Length of the list: " + list.length());
  }
}