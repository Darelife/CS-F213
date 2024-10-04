package MidsemFuncs;

import java.util.Scanner;

class LinkedList {
  class Node {
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  Node head;
  static int numNodes = 0;

  void addNode(int data) {
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
    numNodes++;
  }

  void display() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }
}

public class createLL {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the number of linked lists to be created: ");
    int numLinkedLists = scanner.nextInt();

    LinkedList[] linkedLists = new LinkedList[numLinkedLists];

    for (int i = 0; i < numLinkedLists; i++) {
      linkedLists[i] = new LinkedList();
      System.out.print("Enter the number of nodes for linked list " + (i + 1) + ": ");
      int numNodes = scanner.nextInt();

      for (int j = 0; j < numNodes; j++) {
        System.out.print("Enter data for node " + (j + 1) + ": ");
        int data = scanner.nextInt();
        linkedLists[i].addNode(data);
      }
    }

    System.out.println("\nDisplaying all linked lists:");
    for (int i = 0; i < numLinkedLists; i++) {
      System.out.print("Linked list " + (i + 1) + ": ");
      linkedLists[i].display();
    }

    System.out.println("\nTotal number of nodes created: " + LinkedList.numNodes);
  }
}