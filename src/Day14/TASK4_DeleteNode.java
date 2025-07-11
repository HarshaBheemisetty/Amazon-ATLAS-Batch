package Day14;

class Node8 {
    int data;
    Node8 next;

    Node8(int data) {
        this.data = data;
    }
}

public class TASK4_DeleteNode {
    Node8 head = null;
    Node8 tail = null;

    // Method to add node at end
    public void push(int data) {
        Node8 newNode1 = new Node8(data);
        if (head == null) {
            head = newNode1;
            tail = newNode1;
            newNode1.next = head;
        } else {
            tail.next = newNode1;
            tail = newNode1;
            tail.next = head;
        }
    }

    // Alternative method to delete a node
    public void delete2(int key) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Case 1: Only one node in the list
        if (head == tail && head.data == key) {
            head = null;
            tail = null;
            System.out.println("Deleted node with value: " + key);
            return;
        }

        // Case 2: Deleting the head
        if (head.data == key) {
            head = head.next;
            tail.next = head;
            System.out.println("Deleted node with value: " + key);
            return;
        }

        // Case 3: Deleting any node other than head
        Node8 current = head;
        while (current.next != head) {
            if (current.next.data == key) {
                if (current.next == tail) {
                    tail = current;
                }
                current.next = current.next.next;
                System.out.println("Deleted node with value: " + key);
                return;
            }
            current = current.next;
        }

        System.out.println("Node with value " + key + " not found.");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node8 current = head;
        System.out.print("Circular Linked List Elements: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        TASK4_DeleteNode cll = new TASK4_DeleteNode();

        cll.push(10);
        cll.push(20);
        cll.push(30);
        cll.push(40);

        cll.display();

        cll.delete2(10); // Delete head
        cll.display();

        cll.delete2(40); // Delete tail
        cll.display();

        cll.delete2(25); // Not found
        cll.display();

        cll.delete2(20);
        cll.delete2(30); // All deleted
        cll.display();
    }
}
