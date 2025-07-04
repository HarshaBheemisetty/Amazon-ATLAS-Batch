package Day14;

class Node7 {
    int data;
    Node7 next;

    Node7(int data) {
        this.data = data;
        this.next = null;
    }
}

class Task3_CircularLinkedLIst {
    Node7 head = null;
    Node7 tail = null;

    // Method to add node at the end (tail)
    public void push(int data) {
        Node7 newNode = new Node7(data);

        if (head == null) {
            // First node: points to itself
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            // Add after tail and make new node the new tail
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Make it circular
        }
    }

    // Method to display circular linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node7 current = head;
        System.out.print("Circular Linked List Elements: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head); // Stop after one full loop
        System.out.println();
    }

    public static void main(String[] args) {
        Task3_CircularLinkedLIst cll = new Task3_CircularLinkedLIst();

        // Insert 4 elements
        cll.push(10);
        cll.push(20);
        cll.push(30);
        cll.push(40);

        // Display the circular list
        cll.display();
    }
}
