package Day13;

public class TASK17_DoublyLinkedList {
    static class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null, tail = null;

    void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void displayForward() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    void displayBackward() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
    }

    public static void main(String[] args) {
        TASK17_DoublyLinkedList list = new TASK17_DoublyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.print("Forward: ");
        list.displayForward();
        System.out.print("\nBackward: ");
        list.displayBackward();
    }
}

