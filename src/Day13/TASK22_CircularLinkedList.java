package Day13;

public class TASK22_CircularLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null, tail = null;

    void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    void display() {
        if (head == null) return;
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
    }

    public static void main(String[] args) {
        TASK22_CircularLinkedList list = new TASK22_CircularLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.display();
    }
}

